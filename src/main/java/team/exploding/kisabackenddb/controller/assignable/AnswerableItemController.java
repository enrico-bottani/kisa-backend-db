package team.exploding.kisabackenddb.controller.assignable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.epage.MRCAnswerableItemDTO;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.service.MRCAnswerableItemService;

@Controller
@RequestMapping("/api")
public class AnswerableItemController {
    @Autowired
    MRCAnswerableItemService mrcAnswerableItemService;
    @CrossOrigin
    @PutMapping(value = "/answerable_item/{id}.json")
    public ResponseEntity<MRCAnswerableItemDTO> editById(@PathVariable(name = "id") long id, @RequestBody MRCAnswerableItem mrcAnswItem){
        return ResponseEntity.of(mrcAnswerableItemService.updateById(id, mrcAnswItem));
    }
    @CrossOrigin
    @GetMapping(value = "/answerable_item/{id}.json")
    public ResponseEntity<MRCAnswerableItem> findById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(mrcAnswerableItemService.findById(id));
    }
    @CrossOrigin
    @DeleteMapping(value = "/answerable_item/{id}.json")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") long id){
        mrcAnswerableItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
