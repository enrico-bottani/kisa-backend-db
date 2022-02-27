package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.MRCAnswerableItemDTO;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;

@Component
public class MRCAnswerableItemMapper {
    public MRCAnswerableItemDTO map(MRCAnswerableItem assignable) {
        return MRCAnswerableItemDTO.builder()
                .id(assignable.getId())
                .choice(assignable.getChoice())
                .solution(assignable.getSolution())
                .build();
    }
}
