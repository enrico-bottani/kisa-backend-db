package team.exploding.kisabackenddb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExerciseServiceTest {

    @Autowired
    ExerciseService exerciseService;

    @Test
    void findById() {
    }

    @Test
    void addNew() {
        var exercise =  exerciseService.addNewExercise(ExerciseDTO.builder().title("test").build());
        assertEquals("test",exercise.get().getTitle());
    }
    @Test
    void addNew_TitleNull() {
        var exercise =  exerciseService.addNewExercise(ExerciseDTO.builder().title(null).build());
        assertEquals("",exercise.get().getTitle());
    }
    @Test
    void findAll() {
    }

    @Test
    void addSentenceToExerciseHavingId() {
        var exercise =  exerciseService.addNewExercise(ExerciseDTO.builder().title("test").build());
        var sentence = exerciseService.addSentenceToExerciseHavingId(exercise.get().getId());
        assertEquals(1,exerciseService.findById(exercise.get().getId()).get().getPages().size());
    }
}
