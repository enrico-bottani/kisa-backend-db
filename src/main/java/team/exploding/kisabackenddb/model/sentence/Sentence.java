package team.exploding.kisabackenddb.model.sentence;

import lombok.*;
import team.exploding.kisabackenddb.model.exercise.Exercise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    List<String> strings = new ArrayList<>();
    @OneToMany(mappedBy = "sentence",fetch = FetchType.LAZY)
    List<RadioGroup> radioGroups = new ArrayList<>();
}
