package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.epage.ExercisePageDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.EPageMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.exercise.ExercisePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExerciseMapper {
    @Autowired
    EPageMapper ePageMapper;
    public ExerciseDTO map(Exercise e){
        List<ExercisePageDTO> pages = e.getPages()==null?
                new ArrayList<>():e.getPages().stream().map(ePageMapper::map).collect(Collectors.toList());
        return ExerciseDTO.builder()
                .id(e.getId())
                .title(e.getTitle())
                .pages(pages)
                .build();
    }
}
