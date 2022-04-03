package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.sentence.RadioGroup;

public interface RadioGroupRepository extends JpaRepository<RadioGroup, Long> {
}
