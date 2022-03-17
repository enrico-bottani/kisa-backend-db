package team.exploding.kisabackenddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.exploding.kisabackenddb.dto.KisaUserDatailsEntityDTO;
import team.exploding.kisabackenddb.service.KisaUserDetailsService;
import team.exploding.kisabackenddb.service.UserCheckService;

@Controller
@RequestMapping("/api/auth")
public class KUserController {
    @Autowired
    UserCheckService userCheckService;

    @CrossOrigin
    @GetMapping(value = "/username.json")
    public ResponseEntity<String> getCurrentUserName(){
        String username = userCheckService.getUserNameOrElseThrowException();
        return ResponseEntity.ok(username);
    }
}
