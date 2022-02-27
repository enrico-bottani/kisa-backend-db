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
public class MRCChoosenItemDTO {
    private Long id;
    private MRCAnswerableItem mrcAnswerableItem;
    private Attempt attempt;
}
