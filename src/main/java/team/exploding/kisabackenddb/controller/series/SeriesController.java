package team.exploding.kisabackenddb.controller.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
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




    /*@GetMapping(value = "/series.json")
    public ResponseEntity<List<SeriesDTO>> getAllSeries() {
        return ResponseEntity.ok(seriesController.getAll());
    }*/


    @GetMapping(value = "/series/{seriesId}.json")
    public ResponseEntity<SeriesDTO> getSeries(@PathVariable Long seriesId) {
        return ResponseEntity.of(seriesController.getSeriesById(seriesId));
    }
    @PostMapping(value = "/series/{seriesId}/exercise.json")
    public ResponseEntity<ExerciseDTO> addNewExercise(@PathVariable Long seriesId, @RequestBody ExerciseDTO exerciseDTO) {

        String user = userCheckService.getUserNameOrElseThrowException();
        String seriesUser = seriesController.getResourceUserName(seriesId);
        if (!user.equals(seriesUser))throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        return ResponseEntity.ok(seriesController.addNewExercise(seriesId,exerciseDTO));
    }

    @PostMapping (value = "/series.json")
    public ResponseEntity<SeriesDTO> addNewSeries(@RequestBody SeriesDTO seriesDTO) {
        String user = userCheckService.getUserNameOrElseThrowException();
        return ResponseEntity.ok(seriesController.addNewSeriesOfUser(seriesDTO.getTitle(), user));
    }
}
