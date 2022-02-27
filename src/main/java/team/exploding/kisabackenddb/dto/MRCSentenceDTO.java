package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.assignables.Assignable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MRCSentenceDTO {
    Long id;
    List<AssignableDTO> assignables;
}
