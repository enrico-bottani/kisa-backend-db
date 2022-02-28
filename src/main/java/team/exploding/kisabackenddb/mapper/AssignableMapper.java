package team.exploding.kisabackenddb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.dto.MRCAnswerableDTO;
import team.exploding.kisabackenddb.dto.STRConstantDTO;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.assignables.constant.STRConstant;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;

import java.util.stream.Collectors;

import static team.exploding.kisabackenddb.model.assignables.AssignableType.RC_ANSWERABLE;
import static team.exploding.kisabackenddb.model.assignables.AssignableType.STRING;

@Component
public class AssignableMapper {
    @Autowired
    MRCAnswerableItemMapper answItemMapper;
    public AssignableDTO map(Assignable assignable) {
        var assignableType = assignable.getType();

        if (assignableType.equals(RC_ANSWERABLE.toString())) {
            MRCAnswerable mrcAnswerable = (MRCAnswerable) assignable;
            return MRCAnswerableDTO.builder()
                    .type(mrcAnswerable.getType())
                    .answerableItems(mrcAnswerable
                            .getAnswerableItems().stream()
                            .map(answItemMapper::map).collect(Collectors.toList()))
                    .id(assignable.getId())
                    .position(assignable.getPosition()).build();
        }
        else if (assignableType.equals(STRING.toString())) {
            STRConstant mrcAnswerable = (STRConstant) assignable;
            return STRConstantDTO.builder()
                    .string(mrcAnswerable.getString())
                    .type(mrcAnswerable.getType())
                    .id(mrcAnswerable.getId())
                    .position(assignable.getPosition()).build();
        }

        else {
            return AssignableDTO.builder()
                    .type(assignable.getType())
                    .id(assignable.getId())
                    .position(assignable.getPosition()).build();
        }
    }
}
