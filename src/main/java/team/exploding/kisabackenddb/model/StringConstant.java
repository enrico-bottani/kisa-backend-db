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
@Table(name = "STRING_CONSTANT")
public class StringConstant {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    private String string;

    @ManyToOne
    @JoinColumn(name="MRC_SENTENCE")
    MRCSentence mrcSentence;
}
