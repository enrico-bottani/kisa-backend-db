package team.exploding.kisabackenddb.controller.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;
import team.exploding.kisabackenddb.service.ExerciseService;
import team.exploding.kisabackenddb.service.UserCheckService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    UserCheckService userCheckService;

    @CrossOrigin
    @GetMapping(value = "/exercises/{id}.json")
    public ResponseEntity<ExerciseDTO> getById(@PathVariable(name = "id") long id) {
        return ResponseEntity.of(exerciseService.findById(id));
    }

    @CrossOrigin
    @PostMapping(value = "/exercises.json")
    public ResponseEntity<ExerciseDTO> addNewExercise(@RequestBody ExerciseDTO exerciseDTO) {
        String user = userCheckService.getUserNameOrElseThrowException();
        return ResponseEntity.of(exerciseService.addNewExercise(exerciseDTO, user));
    }

    @CrossOrigin
    @PostMapping(value = "/exercises/{id}/mrc_sentence.json")
    public ResponseEntity<MRCSentenceDTO> addSentenceToExerciseHavingId(@PathVariable(name = "id") long id) {
        String user = userCheckService.getUserNameOrElseThrowException();
            ResponseEntity.of(exerciseService.addSentenceToExerciseHavingId(id,user));
        return ResponseEntity.of(Optional.empty());
    }

    @CrossOrigin
    @GetMapping(value = "/exercises.json")
    public ResponseEntity<List<ExerciseDTO>> getAll() {
        return ResponseEntity.ok(exerciseService.findAll());
    }
}
