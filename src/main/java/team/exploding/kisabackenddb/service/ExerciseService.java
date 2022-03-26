package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseMapper exerciseMapper;
    @Autowired
    KisaUserDatailsEntityRepository userDetailsRepository;
    @Autowired
    ServiceUtils serviceUtils;

    private Exercise getExerciseOrThrowException(Long seriesId) {
        var optSeries = exerciseRepository.findById(seriesId);
        if (optSeries.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return optSeries.get();
    }

    @Transactional
    public Optional<ExerciseDTO> findById(long id) {
        return exerciseRepository.findExerciseById(id).map(exerciseMapper::map);
    }

    // Aggiungi un nuovo esercizio
    public Optional<ExerciseDTO> addNewExercise(ExerciseDTO exerciseDTO, String username) {
        var user = userDetailsRepository.findByUserName(username);
        if (exerciseDTO == null || user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
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

    public Optional<ExerciseDTO> editExercise(long id, ExerciseDTO exerciseDTO) {
        var exercise = getExerciseOrThrowException(id);
        exercise.setTitle(exerciseDTO.getTitle());
        return Optional.of(exerciseRepository.save(exercise)).map(exerciseMapper::map);
    }

    public String getExerciseUserName(long id) {
        var exercise = getExerciseOrThrowException(id);
        return exercise.getSeries().getAuthor().getUserName();
    }
}
