package team.exploding.kisabackenddb.controller.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.service.ExerciseService;
import team.exploding.kisabackenddb.service.ServiceUtils;
import team.exploding.kisabackenddb.service.UserCheckService;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    UserCheckService userCheckService;
    @Autowired
    ServiceUtils serviceUtils;

    @GetMapping(value = "/exercises/{seriesId}/editable.json")
    public ResponseEntity<Map<Object, Object>> isEditable(@PathVariable Long seriesId) {
        String user = userCheckService.getUserNameOrElseThrowException();
        String seriesUser = exerciseService.getExerciseUserName(seriesId);
        return ResponseEntity.ok(Map.of("editable", user.equals(seriesUser)));
    }
    @CrossOrigin
    @GetMapping(value = "/exercises/{id}.json")
    public ResponseEntity<ExerciseDTO> getExerciseById(@PathVariable(name = "id") long id) {
        return ResponseEntity.of(exerciseService.findById(id));
    }

    @CrossOrigin
    @PutMapping(value = "/exercises/{id}.json")
    public ResponseEntity<ExerciseDTO> editExerciseHavingId(@PathVariable(name = "id") long id,
                                                            @RequestBody ExerciseDTO exerciseDTO) {
        String userName = userCheckService.getUserNameOrElseThrowException();
        String resourceUsername = exerciseService.getExerciseUserName(id);
        if (!userName.equals(resourceUsername))throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        var newExercise = exerciseService.editExercise(id, exerciseDTO);
        return ResponseEntity.of(newExercise);
    }
    @PostMapping(value = "/exercises/{id}/sentence.json")
    public ResponseEntity<SentenceDTO> editSentence(@PathVariable(name = "id") long id) {

        String user = userCheckService.getUserNameOrElseThrowException();
        String seriesUser = exerciseService.getExerciseUserName(id);
        if (!user.equals(seriesUser)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        return ResponseEntity.of(exerciseService.addNewSentence(id));
    }
}
