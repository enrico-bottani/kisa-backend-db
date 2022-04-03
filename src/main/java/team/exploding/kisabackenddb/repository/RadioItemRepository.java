package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.sentence.RadioItem;

public interface RadioItemRepository extends JpaRepository<RadioItem, Long> {
}
