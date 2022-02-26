package team.exploding.kisabackenddb.model;

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
@Table(name = "MRC_SENTENCE")
public class MRCSentence {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @OneToMany(mappedBy = "mrcSentence",fetch = FetchType.LAZY)
    List<StringConstant> strings;
}
