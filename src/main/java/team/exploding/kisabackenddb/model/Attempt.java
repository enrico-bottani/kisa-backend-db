package team.exploding.kisabackenddb.model;

import lombok.*;

import javax.persistence.*;
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
}
