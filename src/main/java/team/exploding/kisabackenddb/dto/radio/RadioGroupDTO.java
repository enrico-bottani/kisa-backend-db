package team.exploding.kisabackenddb.dto.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.sentence.RadioGroup;
import team.exploding.kisabackenddb.model.sentence.RadioItem;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RadioGroupDTO {
    List<RadioItemDTO> radioItems;
    long id;
    public RadioGroupDTO(RadioGroup radioGroup){
        this.radioItems = radioGroup.getRadioGroups().stream().map(RadioItemDTO::new).collect(Collectors.toList());
        this.id = radioGroup.getId();
    }
}
