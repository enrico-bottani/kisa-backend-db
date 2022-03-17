package team.exploding.kisabackenddb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.mapper.editor.AssignableMapper;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class MRCSentenceMapper {
    @Autowired
    AssignableMapper assignableMapper;
    public MRCSentenceDTO map(MRCSentence kuser){
        var assignableList =kuser.getAssignables();
        if (kuser.getAssignables() == null){
            assignableList = new ArrayList<>();
        }
        return MRCSentenceDTO.builder()
                .id(kuser.getId())
                .assignables(assignableList.stream()
                        .map(assignableMapper::map).collect(Collectors.toList()))
                .build();
    }
}
