package team.exploding.kisabackenddb.model.sentence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.assignables.Assignable;
import team.exploding.kisabackenddb.model.exercise.ExercisePage;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "MRC_SENTENCE")
public class MRCSentence extends ExercisePage {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Long id;
    @OneToMany(mappedBy = "mrcSentence",fetch = FetchType.EAGER)
    List<Assignable> assignables;
}
