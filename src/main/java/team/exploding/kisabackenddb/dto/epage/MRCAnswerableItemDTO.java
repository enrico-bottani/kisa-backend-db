package team.exploding.kisabackenddb.dto.epage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MRCAnswerableItemDTO {
    private Long id;
    String choice;
    int solution;
}
