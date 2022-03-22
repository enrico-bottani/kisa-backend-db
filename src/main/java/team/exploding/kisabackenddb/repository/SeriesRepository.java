package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.series.Series;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findAllByAuthor_UserName(String authorUsername);
}
