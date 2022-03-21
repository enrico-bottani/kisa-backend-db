package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.MRCSentenceMapper;
import team.exploding.kisabackenddb.mapper.editor.ExerciseMapper;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;
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
    @Autowired
    MRCSentenceMapper mrcSentenceMapper;
    @Autowired
    KisaUserDatailsEntityRepository userDetailsRepository;

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


        return Optional.of(exerciseRepository.save(Exercise.builder().title(title).author(user.get()).build()))
                .map(exerciseMapper::map);
    }

    @Transactional(readOnly = true)
    public List<ExerciseDTO> findAll() {
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::map).collect(Collectors.toList());
    }


    @Transactional(readOnly = false)
    public Optional<MRCSentenceDTO> addSentenceToExerciseHavingId(long id, String userName) {
        var optexercise = exerciseRepository.findById(id);
        if (optexercise.isEmpty()) {
            return Optional.empty();
        }
        if (!optexercise.get().getAuthor().getUserName().equals(userName)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        var exercise = optexercise.get();

        var mrcSentence = MRCSentence.builder()
                .exercise(exercise).build();
        return Optional.of(mrcSentenceRepository.save(mrcSentence)).map(mrcSentenceMapper::map);
    }
}
