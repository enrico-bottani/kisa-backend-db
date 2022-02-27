package team.exploding.kisabackenddb.model.assignables.mrc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.assignables.Assignable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ASSIGN_MRC_ANSWERABLE")
public class MRCAnswerable extends Assignable {
}