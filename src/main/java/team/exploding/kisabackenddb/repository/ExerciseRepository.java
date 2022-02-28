package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.model.KUser;
import team.exploding.kisabackenddb.model.exercise.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
