package team.exploding.kisabackenddb.model.assignables;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import team.exploding.kisabackenddb.model.MRCSentence;

import javax.persistence.*;

@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ASSIGN__")
public class Assignable {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    protected Long id;
    int position;
    protected final String type = AssignableType.Undefined.toString();
    @ManyToOne
    @JoinColumn(name="mcr_sentence_fk")
    MRCSentence mrcSentence;
}