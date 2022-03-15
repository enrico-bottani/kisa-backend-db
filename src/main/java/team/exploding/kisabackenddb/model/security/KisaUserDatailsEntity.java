package team.exploding.kisabackenddb.model.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
