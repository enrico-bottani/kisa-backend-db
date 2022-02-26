package team.exploding.kisabackenddb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.MRCAnswerable;
import team.exploding.kisabackenddb.model.MRCAnswerableItem;

public interface MRCAnswerableItemRepository  extends JpaRepository<MRCAnswerableItem, Long> {
}
