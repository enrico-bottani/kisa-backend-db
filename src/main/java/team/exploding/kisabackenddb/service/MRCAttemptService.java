package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.dto.AttemptAnswerMapDTO;
import team.exploding.kisabackenddb.mapper.AttemptMapper;
import team.exploding.kisabackenddb.repository.AttemptRepository;

import java.util.Optional;

@Service
public class MRCAttemptService {
    @Autowired
    AttemptRepository attemptRepository;
    @Autowired
    AttemptMapper attemptMapper;
    public Optional<AttemptAnswerMapDTO> findById(long id){
        var rtn =  attemptRepository.findById(id);
        return rtn.map(attemptMapper::mapAsAnswSheet);
    }
}
