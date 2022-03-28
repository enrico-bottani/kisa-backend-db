package team.exploding.kisabackenddb.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.dto.KisaUserDatailsEntityDTO;
import team.exploding.kisabackenddb.dto.SentenceDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseDTO {
    private String title;
    private Long id;
    private List<SentenceDTO> sentences;
}
