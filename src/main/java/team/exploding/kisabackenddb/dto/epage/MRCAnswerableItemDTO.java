package team.exploding.kisabackenddb.dto.epage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.MRCChoosenItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MRCAnswerableItemDTO {
    private Long id;
    String choice;
    int solution;
    private Long _exerciseId;
    private Long _exercisePageId;
    private Long _assignableId;
}
