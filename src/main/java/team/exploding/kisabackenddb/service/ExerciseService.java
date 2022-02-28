package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.ExerciseMapper;
import team.exploding.kisabackenddb.repository.ExerciseRepository;

import java.util.Optional;

@Component
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseMapper exerciseMapper;
    public Optional<ExerciseDTO> findById(long id){
        return exerciseRepository.findById(id).map(exerciseMapper::map);
    }
}
