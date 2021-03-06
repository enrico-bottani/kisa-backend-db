package team.exploding.kisabackenddb.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import team.exploding.kisabackenddb.controller.exercise.ExerciseController;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.service.ExerciseService;
import team.exploding.kisabackenddb.service.UserCheckService;

import java.util.List;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = ExerciseController.class)
public class ExerciseControllerTest {
    @MockBean
    private ExerciseService exerciseService;
    @MockBean
    private UserCheckService userCheckService;
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    private UserDetailsService userDetailsService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Should List all the exercises when making GET request to endpoint - /exercises.json")
    public void shouldListAllExercises() throws Exception {
        Mockito.when(exerciseService.findAll()).thenReturn(List.of(ExerciseDTO.builder().id(123L).build()));
        Mockito.when(userCheckService.getUserNameOrElseThrowException()).thenReturn("Enrico");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/exercises.json"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(123)));
    }

    @Test
    @DisplayName("Should List all the exercises when making GET request to endpoint - /exercises.json")
    public void post() throws Exception {
        Mockito.when(
                exerciseService.addSentenceToExerciseHavingId(123,"Enrico")).thenReturn(
                Optional.ofNullable(MRCSentenceDTO.builder().id(4L).build())
        );
        Mockito.when(userCheckService.getUserNameOrElseThrowException()).thenReturn("Enrico");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/exercises/123/mrc_sentence.json"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(4)));
    }

}
//http://localhost:8081/exercises.json
