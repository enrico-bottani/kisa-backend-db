package team.exploding.kisabackenddb.dto.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.sentence.RadioItem;

@Data
@NoArgsConstructor
public class RadioItemDTO {
    String value;
    Long id;
    boolean correct;
    public RadioItemDTO(RadioItem radioItem){
        this.value = radioItem.getValue();
        this.id = radioItem.getId();
        this.correct = radioItem.isCorrect();
    }
}
