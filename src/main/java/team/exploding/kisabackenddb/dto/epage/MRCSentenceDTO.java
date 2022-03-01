package team.exploding.kisabackenddb.dto.epage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.model.assignables.Assignable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MRCSentenceDTO extends ExercisePageDTO{
    List<AssignableDTO> assignables;
    private final String type = "RCT";
}
