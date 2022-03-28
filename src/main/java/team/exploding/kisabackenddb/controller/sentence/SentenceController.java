package team.exploding.kisabackenddb.controller.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.service.SentenceService;

@Controller
@RequestMapping("/api")
public class SentenceController {
    @Autowired
    SentenceService sentenceService;
    @GetMapping(value = "/sentences/{sentenceId}.json")
    public ResponseEntity<SentenceDTO> getSeries(@PathVariable Long sentenceId) {
        return ResponseEntity.of(sentenceService.getSentenceById(sentenceId));
    }
}
