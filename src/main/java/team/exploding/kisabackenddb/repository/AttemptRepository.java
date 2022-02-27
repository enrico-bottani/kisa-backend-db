package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
}
