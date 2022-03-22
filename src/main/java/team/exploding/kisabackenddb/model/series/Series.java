package team.exploding.kisabackenddb.model.series;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.exercise.ExercisePage;
import team.exploding.kisabackenddb.model.security.KisaUserDatailsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SERIES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Series {
    @Id
    @GeneratedValue
    private long id;

    String title;

    @OneToMany(mappedBy = "series",fetch = FetchType.EAGER)
    List<Exercise> exercises = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    KisaUserDatailsEntity author;
}
