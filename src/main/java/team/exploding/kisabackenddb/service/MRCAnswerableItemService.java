package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.exploding.kisabackenddb.dto.epage.MRCAnswerableItemDTO;
import team.exploding.kisabackenddb.mapper.editor.MRCAnswerableItemMapper;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.repository.assignables.MRCAnswerableItemRepository;

import java.util.Optional;

@Service
public class MRCAnswerableItemService {
    @Autowired
    MRCAnswerableItemRepository answerableItemRepository;
    @Autowired
    MRCAnswerableItemMapper mrcAnswerableItemMapper;
    @Transactional
    public Optional<MRCAnswerableItem> findById(long id) {
        return  answerableItemRepository.findById(id);
    }

    @Transactional
    public Optional<MRCAnswerableItemDTO> updateById(long id, MRCAnswerableItem mrcAnswItem) {
        var answer = answerableItemRepository.findById(id);
        if (answer.isEmpty()) {
            return answer.map(mrcAnswerableItemMapper::map);
        }
        answer.get().setChoice(mrcAnswItem.getChoice());
        // questa logica permette anche di deselzionare
        answer.get().getMrcAnswerable().getAnswerableItems().forEach(answerable->{
            answerable.setSolution(0);
        });
        answer.get().setSolution(mrcAnswItem.getSolution());
        answerableItemRepository.save(answer.get());
        return answer.map(mrcAnswerableItemMapper::map);
    }

    public void deleteById(long id) {
        answerableItemRepository.deleteById(id);
    }
}
