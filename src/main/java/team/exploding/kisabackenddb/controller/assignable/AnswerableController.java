package team.exploding.kisabackenddb.controller.assignable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.dto.epage.MRCAnswerableItemDTO;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.service.MRCAnswerableItemService;
import team.exploding.kisabackenddb.service.MRCAnswerableService;

@Controller
@RequestMapping("/api")
public class AnswerableController {
    @Autowired
    MRCAnswerableService mrcAnswerableService;
    @CrossOrigin
    @PostMapping(value = "/answerable/{id}/answerable_item.json")
    public ResponseEntity<AssignableDTO> addAnswerableItemToAnswerableId(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcAnswerableService.addAnswerableItemToAnswerableId(id));
    }
}
