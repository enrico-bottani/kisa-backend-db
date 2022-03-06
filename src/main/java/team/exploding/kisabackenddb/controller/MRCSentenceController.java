package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.service.MRCSentenceService;

@Controller
public class MRCSentenceController {
    @Autowired
    MRCSentenceService mrcSentenceService;
    @CrossOrigin
    @GetMapping(value = "/sentence/{id}.json")
    public ResponseEntity<MRCSentenceDTO> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcSentenceService.findById(id));
    }
    @CrossOrigin
    @DeleteMapping(value = "/sentence/{id}.json")
    public ResponseEntity<Object> daleteById(@PathVariable(name = "id") long id){
        mrcSentenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PostMapping(value = "/sentence/{id}/assignable.json")
    public ResponseEntity<MRCSentenceDTO> addAssignable(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcSentenceService.addAssignableBySentenceId(id));
    }
}
