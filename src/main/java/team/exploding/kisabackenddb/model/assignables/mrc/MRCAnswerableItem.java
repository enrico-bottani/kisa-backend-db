package team.exploding.kisabackenddb.model.assignables.mrc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.Attempt;
import team.exploding.kisabackenddb.model.MRCChoosenItem;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MRC_ANSWERABLE_ITEM")
public class MRCAnswerableItem {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="MRC_ANSWERABLE")
    MRCAnswerable mrcAnswerable;
    @OneToMany(mappedBy = "mrcAnswerableItem",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<MRCChoosenItem> choosenItems;
    String choice;
    int solution = -1;
}
