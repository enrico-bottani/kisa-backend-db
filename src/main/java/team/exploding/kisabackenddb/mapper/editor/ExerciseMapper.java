package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.EPageMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;

import java.util.stream.Collectors;

@Component
public class ExerciseMapper {
    @Autowired
    EPageMapper ePageMapper;
    public ExerciseDTO map(Exercise e){

        return ExerciseDTO.builder()
                .id(e.getId())
                .title(e.getTitle())
                .pages(e.getPages().stream().map(ePageMapper::map).collect(Collectors.toList()))
                .build();
    }
}
