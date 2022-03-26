package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;

@Component
public class ExerciseMapper {
    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;

    public ExerciseDTO map(Exercise e) {
        return ExerciseDTO.builder()
                .id(e.getId())
                .title(e.getTitle())
                .build();
    }
}
