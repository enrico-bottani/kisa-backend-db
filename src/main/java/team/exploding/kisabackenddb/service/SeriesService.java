package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.SeriesMapper;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.series.Series;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;
import team.exploding.kisabackenddb.repository.SeriesRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeriesService {
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    ExerciseMapper exerciseMapper;
    @Autowired
    SeriesMapper seriesMapper;
    @Autowired
    KisaUserDatailsEntityRepository userDetailsRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;
    @Autowired
    ServiceUtils serviceUtils;


    private Series getSeriesByIdOrThrowException(Long seriesId) {
        var optSeries = seriesRepository.findById(seriesId);
        if (optSeries.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return optSeries.get();
    }


    public SeriesDTO addNewSeriesOfUser(String seriesName, String userName) {
        var user = userDetailsRepository.findByUserName(userName);
        if (user.isEmpty()) throw new IllegalStateException();
        Series s = Series.builder().author(user.get()).title(seriesName).build();
        return seriesMapper.map(seriesRepository.save(s));
    }

    public ExerciseDTO addNewExercise(Long seriesId, ExerciseDTO exerciseDTO) {
        var series = getSeriesByIdOrThrowException(seriesId);
        var newExercise = Exercise.builder().series(series).title(exerciseDTO.getTitle()).build();
        return exerciseMapper.map(exerciseRepository.save(newExercise));
    }


    public Optional<SeriesDTO> getSeriesById(Long seriesId) {
        return seriesRepository.findSeriesById(seriesId).map(seriesMapper::map);
    }

    public List<SeriesDTO> getAll() {
        return seriesRepository.findAll().stream().map(seriesMapper::map).collect(Collectors.toList());
    }

    public String getResourceUserName(Long id){
        var series = getSeriesByIdOrThrowException(id);
        return series.getAuthor().getUserName();
    }
}
