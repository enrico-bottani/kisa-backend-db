package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import team.exploding.kisabackenddb.dto.AttemptAnswerMapDTO;
import team.exploding.kisabackenddb.service.MRCAttemptService;

@Controller
public class MRCAnswerSheetController {
    @Autowired
    MRCAttemptService mrcAttemptService;
    @CrossOrigin
    @GetMapping(value = "/answer_sheet/{id}.json")
    public ResponseEntity<AttemptAnswerMapDTO> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcAttemptService.findById(id));
    }
}
