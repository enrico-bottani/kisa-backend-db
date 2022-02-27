package team.exploding.kisabackenddb.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ATTEMPT")
public class Attempt {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private KUser user;
    boolean closed = false;

    @OneToMany(mappedBy = "attempt",fetch = FetchType.LAZY)
    public List<MRCChoosenItem> mrcChoosenItems;
}
