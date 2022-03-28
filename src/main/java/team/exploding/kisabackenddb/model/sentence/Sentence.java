package team.exploding.kisabackenddb.model.sentence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.series.Series;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Sentence")
public class Sentence {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="SERIES_ID", nullable=false)
    Exercise exercise;
    @ElementCollection
    List<String> sentences;

}
