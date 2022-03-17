package team.exploding.kisabackenddb.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;

import java.util.ArrayList;

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
        var exercise = exerciseService.addNewExercise(ExerciseDTO.builder().title("test").build(), "Enrico");
        assertEquals("test", exercise.get().getTitle());
    }

    @Test
    void addNew_TitleNull() {
        var exercise = exerciseService.addNewExercise(ExerciseDTO.builder().title(null).build(), "Enrico");
        assertEquals("", exercise.get().getTitle());
    }

    @Test
    void findAll() {
    }

    @Test
    void addSentenceToExerciseHavingIdCheckAssignablesSize() {
        var exercise = exerciseService.addNewExercise(ExerciseDTO.builder().title("test").build(),
                "Enrico");
        var sentence = exerciseService.addSentenceToExerciseHavingId(exercise.get().getId(),
                "Enrico");
        System.out.println("Exercise ID: "+exercise.get().getId());
        assertEquals(0,sentence.get().getAssignables().size() );
    }

    @Test
    void addSentenceToExerciseHavingId() {
        var exercise = exerciseService.addNewExercise(ExerciseDTO.builder().title("test").build(),
                "Enrico");
        exerciseService.addSentenceToExerciseHavingId(exercise.get().getId(),
                "Enrico");
        System.out.println("Exercise ID: "+exercise.get().getId());
        assertEquals(1, exerciseService.findById(exercise.get().getId()).get().getPages().size());
    }
}
