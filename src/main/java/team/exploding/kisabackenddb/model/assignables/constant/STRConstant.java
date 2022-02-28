package team.exploding.kisabackenddb.model.assignables.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.assignables.AssignableType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ASSIGN_STR_CONSTANT")
public class STRConstant extends Assignable {

    private String string;

    protected final String type = AssignableType.STRING.toString();
}
