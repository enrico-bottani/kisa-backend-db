package team.exploding.kisabackenddb.mapper.editor;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.epage.MRCAnswerableItemDTO;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;

@Component
public class MRCAnswerableItemMapper {
    public MRCAnswerableItemDTO map(MRCAnswerableItem answerableItem) {
        return MRCAnswerableItemDTO.builder()
                .id(answerableItem.getId())
                .choice(answerableItem.getChoice())
                .solution(answerableItem.getSolution())
                .build();
    }
}
