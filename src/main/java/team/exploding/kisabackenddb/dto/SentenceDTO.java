package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.dto.radio.RadioGroupDTO;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SentenceDTO {
    List<String> strings;
    Long id;
    List<RadioGroupDTO> radios;
}
