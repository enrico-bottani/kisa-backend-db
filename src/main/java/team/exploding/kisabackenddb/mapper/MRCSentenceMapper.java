package team.exploding.kisabackenddb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.mapper.editor.AssignableMapper;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;

import java.util.stream.Collectors;

@Component
public class MRCSentenceMapper {
    @Autowired
    AssignableMapper assignableMapper;
    public MRCSentenceDTO map(MRCSentence kuser){
        return MRCSentenceDTO.builder()
                .id(kuser.getId())
                .assignables(kuser.getAssignables().stream()
                        .map(assignableMapper::map).collect(Collectors.toList()))
                .build();
    }
}
