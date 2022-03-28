package team.exploding.kisabackenddb.model.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.Owned;
import team.exploding.kisabackenddb.model.sentence.Sentence;
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
public class Exercise implements Owned {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    String title;

    @ManyToOne
    @JoinColumn(name="SERIES_ID", nullable=false)
    Series series;

    @OneToMany(mappedBy = "exercise",fetch = FetchType.LAZY)
    List<Sentence> sentences = new ArrayList<>();
    @Override
    public String getOwner() {
        return series.getOwner();
    }
}
