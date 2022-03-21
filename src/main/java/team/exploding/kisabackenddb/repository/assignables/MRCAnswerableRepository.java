package team.exploding.kisabackenddb.repository.assignables;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;

public interface MRCAnswerableRepository extends JpaRepository<MRCAnswerable, Long> {
}
