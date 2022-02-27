package team.exploding.kisabackenddb.model.assignables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.MRCSentence;

import javax.persistence.*;

import static team.exploding.kisabackenddb.model.assignables.AssignableType.RC_ANSWERABLE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ASSIGN_STR_CONSTANT")
public class STRConstant extends Assignable{

    private String string;

    protected final String type = AssignableType.STRING.toString();
}
