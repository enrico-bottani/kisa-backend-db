package team.exploding.kisabackenddb.model.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.exploding.kisabackenddb.model.exercise.Exercise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_DETAILS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KisaUserDatailsEntity {
    @Id
    @GeneratedValue
    private long id;
    private String userName;
    private String password;
    private boolean active;

    private String roles;
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    List<Exercise> exercises = new ArrayList<>();
}
