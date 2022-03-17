package team.exploding.kisabackenddb.model.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PAGE__")
public class ExercisePage {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Long id;

    @ManyToOne
    @JoinColumn(name="EXERCISE_ID", nullable=false)
    Exercise exercise;
}
