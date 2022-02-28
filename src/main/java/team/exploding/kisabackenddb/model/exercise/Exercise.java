package team.exploding.kisabackenddb.model.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.assignables.Assignable;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Exercise")
public class Exercise {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    @OneToMany(mappedBy = "exercise",fetch = FetchType.LAZY)
    List<ExercisePage> pages;

    String title;
}
