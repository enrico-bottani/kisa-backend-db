package team.exploding.kisabackenddb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    String choice;
}
