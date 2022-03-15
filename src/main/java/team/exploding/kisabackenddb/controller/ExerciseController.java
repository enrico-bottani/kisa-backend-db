package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;
import team.exploding.kisabackenddb.service.ExerciseService;

import java.util.List;

@Controller
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @CrossOrigin
    @GetMapping(value = "/exercises/{id}.json")
    public ResponseEntity<ExerciseDTO> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(exerciseService.findById(id));
    }
    @CrossOrigin
    @PostMapping(value = "/exercises.json")
    public ResponseEntity<ExerciseDTO> newExercise(){
        return ResponseEntity.of(exerciseService.addNew(ExerciseDTO.builder().title("test").build()));
    }
    @CrossOrigin
    @PostMapping(value = "/exercises/{id}/mrc_sentence.json")
    public ResponseEntity<MRCSentence> addSentenceToExerciseHavingId(@PathVariable(name = "id") long id){
        return ResponseEntity.of(exerciseService.addSentenceToExerciseHavingId(id));
    }
    @CrossOrigin
    @GetMapping(value = "/exercises.json")
    public ResponseEntity<List<ExerciseDTO>> getAll(){
        return ResponseEntity.ok(exerciseService.findAll());
    }
}
