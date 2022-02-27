package team.exploding.kisabackenddb.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.assignables.AssignableType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AssignableDTO {
    protected Long id;
    int position;
    private final String type = AssignableType.Undefined.toString();
}
