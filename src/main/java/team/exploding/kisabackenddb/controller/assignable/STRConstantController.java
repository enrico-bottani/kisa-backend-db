package team.exploding.kisabackenddb.controller.assignable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.exploding.kisabackenddb.dto.STRConstantDTO;
import team.exploding.kisabackenddb.dto.epage.MRCAnswerableItemDTO;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.service.MRCAnswerableItemService;
import team.exploding.kisabackenddb.service.MRCSentenceService;
import team.exploding.kisabackenddb.service.STRConstantService;

@Controller
@RequestMapping("/api")
public class STRConstantController {
    @Autowired
    STRConstantService strConstantService;
    @CrossOrigin
    @PutMapping(value = "/str_constant/{id}.json")
    public ResponseEntity<STRConstantDTO> editById(@PathVariable(name = "id") long id, @RequestBody STRConstantDTO strConstantDTO){
        return ResponseEntity.of(strConstantService.updateById(id, strConstantDTO));
    }
}
