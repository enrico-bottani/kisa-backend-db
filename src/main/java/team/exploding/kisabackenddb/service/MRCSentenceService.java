package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.dto.epage.MRCSentenceDTO;
import team.exploding.kisabackenddb.mapper.MRCSentenceMapper;
import team.exploding.kisabackenddb.model.assignables.AssignableType;
import team.exploding.kisabackenddb.model.assignables.constant.STRConstant;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;
import team.exploding.kisabackenddb.repository.assignables.MRCAnswerableRepository;
import team.exploding.kisabackenddb.repository.MRCSentenceRepository;
import team.exploding.kisabackenddb.repository.assignables.STRConstantRepository;

import java.util.Optional;

@Service
public class MRCSentenceService {
    @Autowired
    MRCSentenceRepository mrcSentenceRepository;
    @Autowired
    STRConstantRepository strConstantRepository;
    @Autowired
    MRCAnswerableRepository mrcAnswerableRepository;
    @Autowired
    MRCSentenceMapper mrcSentenceMapper;

    public Optional<MRCSentenceDTO> findById(long id) {
        return mrcSentenceRepository.findById(id).map(k -> mrcSentenceMapper.map(k));
    }

    public Optional<MRCSentenceDTO> addAssignableBySentenceId(long sentenceId) {
        var optMRCSentence = mrcSentenceRepository
                .findById(sentenceId);
        if (optMRCSentence.isEmpty()) {
            return optMRCSentence.map(mrcSentenceMapper::map);
        }
        var mrcSentence = optMRCSentence.get();
        var assignables = mrcSentence.getAssignables();
        var assignableSize = assignables.size();
        var lastAssignableType = AssignableType.RC_ANSWERABLE.toString();
        if (assignableSize != 0) {
             lastAssignableType = assignables.get(assignableSize-1).getType();
        }
        if (lastAssignableType.equals(AssignableType.RC_ANSWERABLE.toString())){
            var strToAdd = new STRConstant();
            strToAdd.setPosition(assignableSize);
            strToAdd.setMrcSentence(mrcSentence);
            // Save this assignable
            strConstantRepository.save(strToAdd);
            return mrcSentenceRepository
                    .findById(sentenceId).map(mrcSentenceMapper::map);
        }
        var strToAdd = new MRCAnswerable();
        strToAdd.setPosition(assignableSize);
        strToAdd.setMrcSentence(mrcSentence);
        // Save this assignable
        mrcAnswerableRepository.save(strToAdd);
        return mrcSentenceRepository
                .findById(sentenceId).map(mrcSentenceMapper::map);
    }

    public void deleteById(long id) {
        mrcSentenceRepository.deleteById(id);
    }
}
