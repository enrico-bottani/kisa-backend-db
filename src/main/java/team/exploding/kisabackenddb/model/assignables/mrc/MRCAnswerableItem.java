package team.exploding.kisabackenddb.model.assignables.mrc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    String choice;
    int solution = -1;
}
