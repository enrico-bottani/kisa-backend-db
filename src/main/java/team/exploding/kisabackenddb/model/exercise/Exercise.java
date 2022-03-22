package team.exploding.kisabackenddb.model.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.Authored;
import team.exploding.kisabackenddb.model.security.KisaUserDatailsEntity;
import team.exploding.kisabackenddb.model.series.Series;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Exercise")
public class Exercise implements Authored {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    @OneToMany(mappedBy = "exercise",fetch = FetchType.EAGER)
    List<ExercisePage> pages = new ArrayList<>();

    String title;

    @ManyToOne
    @JoinColumn(name="SERIES_ID", nullable=false)
    Series series;

    @Override
    public String recoverAuthorUserName() {
        return series.getAuthor().getUserName();
    }
}
