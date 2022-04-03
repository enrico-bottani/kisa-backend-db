package team.exploding.kisabackenddb.model.sentence;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "radio_group")
public class RadioGroup {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="SENTENCE_ID", nullable=false)
    Sentence sentence;
    @OneToMany(mappedBy = "radios",fetch = FetchType.LAZY)
    List<RadioItem> radioGroups = new ArrayList<>();

}
