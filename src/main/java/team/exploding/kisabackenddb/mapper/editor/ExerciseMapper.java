package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.SentenceMapper;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;

import java.util.stream.Collectors;

@Component
public class ExerciseMapper {
    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;
    @Autowired
    SentenceMapper sentenceMapper;
    public ExerciseDTO map(Exercise e) {
        return ExerciseDTO.builder()
                .id(e.getId())
                .sentences(e.getSentences().stream().map(sentenceMapper::map).collect(Collectors.toList()))
                .title(e.getTitle())
                .build();
    }
}
