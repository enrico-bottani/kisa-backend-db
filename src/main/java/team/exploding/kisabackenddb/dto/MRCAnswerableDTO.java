package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.dto.epage.MRCAnswerableItemDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MRCAnswerableDTO extends AssignableDTO{
    List<MRCAnswerableItemDTO> answerableItems;
}
