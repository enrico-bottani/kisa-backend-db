package team.exploding.kisabackenddb.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.service.MRCSentenceService;

@Controller
@RequestMapping("/api/mrc_sentence")
public class MRCSentenceController {
    @Autowired
    MRCSentenceService mrcSentenceService;
    /*
    @CrossOrigin
    @GetMapping(value = "/{id}.json")
    public ResponseEntity<MRCSentenceDTO> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcSentenceService.findById(id));
    }*/
    @CrossOrigin
    @DeleteMapping(value = "/{id}.json")
    public ResponseEntity<Object> daleteById(@PathVariable(name = "id") long id){
        mrcSentenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PostMapping(value = "/{id}/assignable.json")
    public ResponseEntity<MRCSentenceDTO> addAssignable(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcSentenceService.addAssignableBySentenceId(id));
    }
}
