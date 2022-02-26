package team.exploding.kisabackenddb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.KUser;
import team.exploding.kisabackenddb.model.MRCSentence;

public interface MRCSentenceRepository extends JpaRepository<MRCSentence, Long> {
}
