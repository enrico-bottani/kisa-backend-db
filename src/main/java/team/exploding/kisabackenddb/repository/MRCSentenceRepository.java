package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.MRCSentence;

public interface MRCSentenceRepository extends JpaRepository<MRCSentence, Long> {
}
