package team.exploding.kisabackenddb.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.dto.epage.ExercisePageDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseDTO {
    private String title;
    private List<ExercisePageDTO> pages;
    private Long id;
}
