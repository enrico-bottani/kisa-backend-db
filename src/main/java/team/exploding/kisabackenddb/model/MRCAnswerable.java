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
@Table(name = "MRC_ANSWERABLE")
public class MRCAnswerable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="mcr_sentence_fk")
    MRCSentence mrcSentence;

    int position;
}