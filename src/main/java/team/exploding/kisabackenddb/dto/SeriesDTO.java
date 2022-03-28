package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeriesDTO {
    Long id;
    String title;
    List<ExerciseDTO> exercises;
    KisaUserDatailsEntityDTO user;
}
