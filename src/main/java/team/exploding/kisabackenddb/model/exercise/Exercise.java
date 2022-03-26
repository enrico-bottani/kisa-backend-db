package team.exploding.kisabackenddb.model.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.Owned;
import team.exploding.kisabackenddb.model.series.Series;

import javax.persistence.*;

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

    @Override
    public String getOwner() {
        return series.getOwner();
    }
}
