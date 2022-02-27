package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.dto.KUserDTO;
import team.exploding.kisabackenddb.mapper.KUserMapper;
import team.exploding.kisabackenddb.repository.KUserRepository;

import java.util.Optional;

@Service
public class KUserService {
    @Autowired
    KUserRepository kUserRepository;
    @Autowired
    KUserMapper kUserMapper;

    public Optional<KUserDTO> findById(long id) {
        return kUserRepository.findById(id).map(k -> kUserMapper.map(k));
    }
}
