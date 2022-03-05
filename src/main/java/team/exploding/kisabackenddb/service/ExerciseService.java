package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.MRCSentenceRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    MRCSentenceRepository mrcSentenceRepository;
    @Autowired
    ExerciseMapper exerciseMapper;
    public Optional<ExerciseDTO> findById(long id){
        return exerciseRepository.findById(id).map(exerciseMapper::map);
    }
    public List<ExerciseDTO> finAll(){
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::map).collect(Collectors.toList());
    }

    public Optional<ExerciseDTO> addSentenceToExerciseHavingId(long id) {
        var optexercise= exerciseRepository.findById(id);
        if (optexercise.isEmpty())return optexercise.map(exerciseMapper::map);
        var exercise = optexercise.get();
        var exPages = exercise.getPages();

        var mrcSentence = MRCSentence.builder()
                .position(exPages.get(exPages.size()-1).getPosition()+1)
                .exercise(exercise).build();
        mrcSentenceRepository.save(mrcSentence);
        return exerciseRepository.findById(id).map(exerciseMapper::map);
    }
}
