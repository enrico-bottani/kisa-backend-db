package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team.exploding.kisabackenddb.dto.KUserDTO;
import team.exploding.kisabackenddb.service.KUserService;

@Controller
@RequestMapping("/api")
public class KUserController {
    @Autowired
    KUserService kUserService;
    @CrossOrigin
    @GetMapping(value = "/user/{id}.json")
    public ResponseEntity<KUserDTO> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(kUserService.findById(id));
    }
}
