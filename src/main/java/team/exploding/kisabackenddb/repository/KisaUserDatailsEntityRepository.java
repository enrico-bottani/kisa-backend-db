package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.security.KisaUserDatailsEntity;

import java.util.Optional;

public interface KisaUserDatailsEntityRepository extends JpaRepository<KisaUserDatailsEntity, Long> {
    Optional<KisaUserDatailsEntity> findByUserName(String userName);
}
