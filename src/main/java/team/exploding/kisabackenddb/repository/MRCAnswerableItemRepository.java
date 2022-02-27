package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;

public interface MRCAnswerableItemRepository  extends JpaRepository<MRCAnswerableItem, Long> {
}
