package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.dto.STRConstantDTO;
import team.exploding.kisabackenddb.mapper.MRCSentenceMapper;
import team.exploding.kisabackenddb.mapper.editor.AssignableMapper;
import team.exploding.kisabackenddb.mapper.editor.STRConstantMapper;
import team.exploding.kisabackenddb.model.assignables.constant.STRConstant;
import team.exploding.kisabackenddb.repository.MRCSentenceRepository;
import team.exploding.kisabackenddb.repository.STRConstantRepository;

import java.util.Optional;

@Service
public class STRConstantService {
    @Autowired
    STRConstantMapper strConstantMapper;
    @Autowired
    STRConstantRepository repo;
    public Optional<STRConstantDTO> updateById(long id, STRConstantDTO strConstantDTO){
        var optItem = repo.findById(id);
        if (optItem.isEmpty()){
            return optItem.map(strConstantMapper::map);
        }
        var item = optItem.get();
        item.setString(strConstantDTO.getString());
        repo.save(item);
        return Optional.of(strConstantMapper.map(item));
    }
}
