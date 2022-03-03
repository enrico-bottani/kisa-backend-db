package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.repository.ExerciseRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseMapper exerciseMapper;
    public Optional<ExerciseDTO> findById(long id){
        return exerciseRepository.findById(id).map(exerciseMapper::map);
    }
    public List<ExerciseDTO> finAll(){
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::map).collect(Collectors.toList());
    }
}
