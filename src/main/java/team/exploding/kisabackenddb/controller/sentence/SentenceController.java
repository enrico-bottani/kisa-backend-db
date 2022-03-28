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
import team.exploding.kisabackenddb.service.UserCheckService;

@Controller
@RequestMapping("/api")
public class SentenceController {
    @Autowired
    SentenceService sentenceService;
    @Autowired
    UserCheckService userCheckService;


    @GetMapping(value = "/sentences/{sentenceId}.json")
    public ResponseEntity<SentenceDTO> getSeries(@PathVariable Long sentenceId) {
        return ResponseEntity.of(sentenceService.getSentenceById(sentenceId));
    }

    @PutMapping(value = "/sentences/{seriesId}.json")
    public ResponseEntity<SentenceDTO> editSentence(@PathVariable Long seriesId, @RequestBody SentenceDTO sentenceDTO) {

        String user = userCheckService.getUserNameOrElseThrowException();
        String seriesUser = sentenceService.getResourceUserName(seriesId);
        if (!user.equals(seriesUser)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        return ResponseEntity.of(sentenceService.editSentence(seriesId, sentenceDTO));
    }

}
