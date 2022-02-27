package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.MRCChoosenItem;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;

public interface MRCChoosenItemRepository extends JpaRepository<MRCChoosenItem, Long> {

}
