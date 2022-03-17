package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.epage.ExercisePageDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.EPageMapper;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.exercise.ExercisePage;
import team.exploding.kisabackenddb.model.security.KisaUserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExerciseMapper {
    @Autowired
    EPageMapper ePageMapper;
    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;

    public ExerciseDTO map(Exercise e) {
        List<ExercisePageDTO> pages = e.getPages() == null ?
                new ArrayList<>() : e.getPages().stream().map(ePageMapper::map).collect(Collectors.toList());
        return ExerciseDTO.builder()
                .id(e.getId())
                .title(e.getTitle())
                .author(kisaUserDetailsMapper.mapToDTO(e.getAuthor()))
                .pages(pages)
                .build();
    }
}
