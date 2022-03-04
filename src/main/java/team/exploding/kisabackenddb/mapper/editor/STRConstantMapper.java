package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.dto.STRConstantDTO;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.assignables.constant.STRConstant;

@Component
public class STRConstantMapper {
    public STRConstantDTO map(STRConstant mrcAnswerable) {
        return STRConstantDTO.builder()
                .string(mrcAnswerable.getString())
                .type(mrcAnswerable.getType())
                .id(mrcAnswerable.getId())
                .position(mrcAnswerable.getPosition()).build();
    }
}
