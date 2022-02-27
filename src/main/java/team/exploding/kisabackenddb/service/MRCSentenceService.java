package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.dto.KUserDTO;
import team.exploding.kisabackenddb.dto.MRCSentenceDTO;
import team.exploding.kisabackenddb.mapper.KUserMapper;
import team.exploding.kisabackenddb.mapper.MRCSentenceMapper;
import team.exploding.kisabackenddb.repository.KUserRepository;
import team.exploding.kisabackenddb.repository.MRCSentenceRepository;

import java.util.Optional;
@Service
public class MRCSentenceService {
    @Autowired
    MRCSentenceRepository mrcSentenceRepository;
    @Autowired
    MRCSentenceMapper mrcSentenceMapper;

    public Optional<MRCSentenceDTO> findById(long id) {
        return mrcSentenceRepository.findById(id).map(k -> mrcSentenceMapper.map(k));
    }
}
