package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.SentenceMapper;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.sentence.Sentence;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;
import team.exploding.kisabackenddb.repository.SentenceRepository;

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
    SentenceRepository sentenceRepository;
    @Autowired
    SentenceMapper sentenceMapper;
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

    public Optional<SentenceDTO> addNewSentence(long id) {
        var exercise = exerciseRepository.findExerciseById(id);
        if (exercise.isEmpty()) return Optional.empty();
        var e = exercise.get();

        var newSentence = Sentence.builder().exercise(e).build();

        return Optional.of(sentenceRepository.save(newSentence)).map(sentenceMapper::map);
    }
}
