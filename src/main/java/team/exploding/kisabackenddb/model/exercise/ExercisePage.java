package team.exploding.kisabackenddb.model.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.KUser;
import team.exploding.kisabackenddb.model.assignables.Assignable;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "EXERCISE_PAGE")
public class ExercisePage {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Long id;

    @ManyToOne
    @JoinColumn(name="EXERCISE_ID", nullable=false)
    Exercise exercise;
}
