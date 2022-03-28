package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.controller.sentence.SentenceController;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.dto.exercise.ExerciseDTO;
import team.exploding.kisabackenddb.mapper.SentenceMapper;
import team.exploding.kisabackenddb.model.sentence.Sentence;
import team.exploding.kisabackenddb.repository.SentenceRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class SentenceService {
    @Autowired
    SentenceRepository sentenceRepository;
    @Autowired
    SentenceMapper sentenceMapper;
    public Optional<SentenceDTO> getSentenceById(Long sentenceId){
        return sentenceRepository.findSentenceById(sentenceId).map(sentenceMapper::map);
    }

    public String getResourceUserName(Long sentenceId) {
        return sentenceRepository.findSentenceById(sentenceId).get().getExercise().getSeries().getOwner();
    }

    public Optional<SentenceDTO> editSentence(Long seriesId, SentenceDTO sentenceDTO) {
        var optSentence =  sentenceRepository.findSentenceById(seriesId);
        if(optSentence.isEmpty())return Optional.empty();
        Sentence s = optSentence.get();
        s.setStrings(sentenceDTO.getStrings());
        return Optional.of(sentenceMapper.map(sentenceRepository.save(s)));
    }
}
