package team.exploding.kisabackenddb.controller.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.service.ExerciseService;
import team.exploding.kisabackenddb.service.SeriesService;
import team.exploding.kisabackenddb.service.UserCheckService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class SeriesController {
    @Autowired
    SeriesService seriesController;
    @Autowired
    UserCheckService userCheckService;
    @GetMapping(value = "author/{authorName}/series.json")
    public ResponseEntity<List<SeriesDTO>> getAll(@PathVariable String authorName) {
        return ResponseEntity.ok(seriesController.findByAuthor(authorName));
    }
    @PostMapping (value = "series.json")
    public ResponseEntity<SeriesDTO> addNewSeries(@RequestBody SeriesDTO seriesDTO) {
        String user = userCheckService.getUserNameOrElseThrowException();
        return ResponseEntity.ok(seriesController.addNew(seriesDTO.getTitle(),user));
    }
    @PostMapping(value = "series/{seriesId}/exercise.json")
    public ResponseEntity<ExerciseDTO> addNewExercise(@PathVariable Long seriesId, @RequestBody ExerciseDTO exerciseDTO) {
        String user = userCheckService.getUserNameOrElseThrowException();
        return ResponseEntity.ok(seriesController.addNewExercise(seriesId,exerciseDTO,user));
    }
}
