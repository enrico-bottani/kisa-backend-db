package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import team.exploding.kisabackenddb.dto.KUserDTO;
import team.exploding.kisabackenddb.dto.MRCSentenceDTO;
import team.exploding.kisabackenddb.service.KUserService;
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
}
