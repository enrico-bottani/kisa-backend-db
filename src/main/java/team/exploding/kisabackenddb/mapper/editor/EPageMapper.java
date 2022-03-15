package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.epage.ExercisePageDTO;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.model.exercise.ExercisePage;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;

import java.util.ArrayList;
import java.util.stream.Collectors;
@Component
public class EPageMapper {
    @Autowired
    AssignableMapper assignableMapper;

    public ExercisePageDTO map(ExercisePage e){
        if (e instanceof MRCSentence){
            MRCSentence mrcSentence = (MRCSentence) e;
            return MRCSentenceDTO.builder().id(e.getId())
                    .assignables(mrcSentence.getAssignables()==null?
                            new ArrayList<>()
                            :
                            mrcSentence.getAssignables().stream()
                            .map(assignableMapper::map).collect(Collectors.toList()))
                    .build();
        }
       return ExercisePageDTO.builder()
               .id(e.getId()).build();
    }
}
