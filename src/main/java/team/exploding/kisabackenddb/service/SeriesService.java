package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.SeriesMapper;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.series.Series;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;
import team.exploding.kisabackenddb.repository.SeriesRepository;

import java.util.List;
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

    public List<SeriesDTO> findByAuthor(String authorUsername) {
        return seriesRepository.findAllByAuthor_UserName(authorUsername).stream()
                .map(s -> seriesMapper.map(s)).collect(Collectors.toList());
    }

    public SeriesDTO addNew(String seriesName, String userName) {
        var user = userDetailsRepository.findByUserName(userName);
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        Series s = Series.builder().author(user.get()).title(seriesName).build();
        return seriesMapper.map(seriesRepository.save(s));
    }

    public ExerciseDTO addNewExercise(Long seriesId, ExerciseDTO exerciseDTO,String userName) {
        var user = userDetailsRepository.findByUserName(userName);
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        var series= seriesRepository.findById(seriesId);
        if (series.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        var e = Exercise.builder().series(series.get()).title(exerciseDTO.getTitle()).build();
        return exerciseMapper.map(exerciseRepository.save(e));
    }

}
