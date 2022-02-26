package team.exploding.kisabackenddb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.MRCAnswerable;

public interface MRCAnswerableRepository extends JpaRepository<MRCAnswerable, Long> {
}
