package team.exploding.kisabackenddb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.service.KisaUserDetailsService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    KisaUserDetailsService kisaUserDetailsService;

    @GetMapping(value = "/user/{userName}/series.json")
    public ResponseEntity<List<SeriesDTO>> getAllSeries(@PathVariable String userName) {
        var series = kisaUserDetailsService.findSeriesByUserName(userName);
        return ResponseEntity.ok(series);
    }
}
