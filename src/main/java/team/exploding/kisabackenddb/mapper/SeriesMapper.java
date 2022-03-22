package team.exploding.kisabackenddb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.AssignableMapper;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;
import team.exploding.kisabackenddb.model.series.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeriesMapper {
    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;
    @Autowired
    ExerciseMapper exerciseMapper;

    public SeriesDTO map(Series series) {
        List<ExerciseDTO> seriesEx = new ArrayList<>();
        if (series.getExercises() != null) {
            seriesEx = series.getExercises().stream().map(exerciseMapper::map).collect(Collectors.toList());
        }
        return SeriesDTO.builder()
                .user(kisaUserDetailsMapper.mapToDTO(series.getAuthor()))
                .id(series.getId())
                .title(series.getTitle())
                .exercises(seriesEx)
                .build();
    }
}
