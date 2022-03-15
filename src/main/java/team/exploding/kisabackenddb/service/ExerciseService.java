package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public Optional<ExerciseDTO> findById(long id) {
        return exerciseRepository.findById(id).map(exerciseMapper::map);
    }

    public Optional<ExerciseDTO> addNewExercise(ExerciseDTO exerciseDTO) {
        if (exerciseDTO == null) {
            return Optional.empty();
        }

        var title = "";
        if (exerciseDTO.getTitle() != null) title = exerciseDTO.getTitle();

        return Optional.of(exerciseRepository.save(Exercise.builder().title(title).build()))
                .map(exerciseMapper::map);
    }

    @Transactional(readOnly = true)
    public List<ExerciseDTO> findAll() {
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::map).collect(Collectors.toList());
    }

    public Optional<MRCSentence> addSentenceToExerciseHavingId(long id) {
        return saveNewSentenceToExerciseId(id);
    }

    @Transactional(readOnly = false)
    Optional<MRCSentence> saveNewSentenceToExerciseId(long id) {
        var optexercise = exerciseRepository.findById(id);
        if (optexercise.isEmpty()) return Optional.empty();
        var exercise = optexercise.get();
        var exPages = exercise.getPages();
        var position = 0;
        if (exPages != null && exPages.size() > 0) position = exPages.get(exPages.size() - 1).getPosition() + 1;
        var mrcSentence = MRCSentence.builder()
                .position(position)
                .exercise(exercise).build();
        return Optional.of(mrcSentenceRepository.save(mrcSentence));
    }
}
