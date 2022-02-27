package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.dto.MRCAnswerableDTO;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.assignables.AssignableType;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;

import static team.exploding.kisabackenddb.model.assignables.AssignableType.RC_ANSWERABLE;

@Component
public class AssignableMapper {
    AssignableType assignableType;

    public AssignableDTO map(Assignable assignable) {
        var assignableType = assignable.getType();

        if (assignableType.equals(RC_ANSWERABLE.toString())) {
            MRCAnswerable mrcAnswerable = (MRCAnswerable) assignable;
            return MRCAnswerableDTO.builder()
                    //TODO: Mapping
                    .answerableItems(mrcAnswerable.getAnswerableItems())
                    .id(assignable.getId())
                    .position(assignable.getPosition()).build();
        } else {
            return AssignableDTO.builder().id(assignable.getId()).position(assignable.getPosition()).build();
        }
    }
}
