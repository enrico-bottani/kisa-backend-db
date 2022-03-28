package team.exploding.kisabackenddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.model.sentence.Sentence;

import java.util.Optional;

public interface SentenceRepository extends JpaRepository<Sentence,Long> {
    Optional<Sentence> findSentenceById(Long sentenceId);
}
