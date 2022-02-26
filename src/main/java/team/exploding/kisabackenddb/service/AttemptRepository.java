package team.exploding.kisabackenddb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.Attempt;
import team.exploding.kisabackenddb.model.KUser;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
}
