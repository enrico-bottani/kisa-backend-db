package team.exploding.kisabackenddb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MRC_CHOOSEN_ITEM")
public class MRCChoosenItem {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="MRC_ANSWERABLE_ITEM")
    MRCAnswerableItem mrcAnswerableItem;
    @ManyToOne
    @JoinColumn(name="ATTEMPT")
    Attempt attempt;
}