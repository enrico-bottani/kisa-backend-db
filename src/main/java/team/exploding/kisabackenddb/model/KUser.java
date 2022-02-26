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
@Table(name = "KUser")
public class KUser {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    long id;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    public List<Attempt> answerSheetList;
    String firstName;
}
