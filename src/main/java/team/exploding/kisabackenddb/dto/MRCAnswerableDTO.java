package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MRCAnswerableDTO extends AssignableDTO{
    List<MRCAnswerableItemDTO> answerableItems;
}
