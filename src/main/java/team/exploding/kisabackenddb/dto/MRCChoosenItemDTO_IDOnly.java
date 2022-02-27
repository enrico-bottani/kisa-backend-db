package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.Attempt;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MRCChoosenItemDTO_IDOnly {

    private Long answerable_item_id;
}
