package team.exploding.kisabackenddb.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import team.exploding.kisabackenddb.service.ExerciseService;

@WebMvcTest(controllers = ExerciseController.class)
public class ExerciseControllerTest {
    @MockBean
    private ExerciseService exerciseService;
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    private UserDetailsService userDetailsService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("Should List all the exercises when making GET request to endpoint - /exercises.json")
    public void shouldListAllExercises() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/exercises.json")).andExpect(MockMvcResultMatchers
                .status().is(200));
    }
}
//http://localhost:8081/exercises.json
