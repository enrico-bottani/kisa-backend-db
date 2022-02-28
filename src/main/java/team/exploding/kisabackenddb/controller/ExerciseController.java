package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import team.exploding.kisabackenddb.dto.AttemptAnswerMapDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.service.ExerciseService;
import team.exploding.kisabackenddb.service.MRCAttemptService;

import java.util.List;

@Controller
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @CrossOrigin
    @GetMapping(value = "/exercise/{id}.json")
    public ResponseEntity<ExerciseDTO> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(exerciseService.findById(id));
    }
    @CrossOrigin
    @GetMapping(value = "/exercises.json")
    public ResponseEntity<List<ExerciseDTO>> getAll(){
        return ResponseEntity.ok(exerciseService.finAll());
    }
}
