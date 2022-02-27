package team.exploding.kisabackenddb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.dto.MRCAnswerableDTO;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.assignables.AssignableType;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static team.exploding.kisabackenddb.model.assignables.AssignableType.RC_ANSWERABLE;

@Component
public class AssignableMapper {
    @Autowired
    MRCAnswerableItemMapper mapper;
    public AssignableDTO map(Assignable assignable) {
        var assignableType = assignable.getType();

        if (assignableType.equals(RC_ANSWERABLE.toString())) {
            MRCAnswerable mrcAnswerable = (MRCAnswerable) assignable;
            return MRCAnswerableDTO.builder()
                    .type(mrcAnswerable.getType())
                    //TODO: Mapping
                    .answerableItems(mrcAnswerable
                            .getAnswerableItems().stream()
                            .map(mapper::map).collect(Collectors.toList()))
                    .id(assignable.getId())
                    .position(assignable.getPosition()).build();
        } else {
            return AssignableDTO.builder()
                    .type(assignable.getType())
                    .id(assignable.getId())
                    .position(assignable.getPosition()).build();
        }
    }
}
