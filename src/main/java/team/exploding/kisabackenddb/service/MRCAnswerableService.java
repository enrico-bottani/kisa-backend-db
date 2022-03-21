package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.dto.AssignableDTO;
import team.exploding.kisabackenddb.mapper.editor.AssignableMapper;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.repository.assignables.MRCAnswerableItemRepository;
import team.exploding.kisabackenddb.repository.assignables.MRCAnswerableRepository;

import java.util.Optional;

@Service
public class MRCAnswerableService {
    @Autowired
    AssignableMapper assignableMapper;
    @Autowired
    MRCAnswerableRepository mrcAnswerableRepository;
    @Autowired
    MRCAnswerableItemRepository mrcAnswerableItemRepository;

    public Optional<AssignableDTO> addAnswerableItemToAnswerableId(long answerableId) {
        // Provo ad ottenere l'elemento dove aggiungere l'item
        var optionalMRCAnswerable = mrcAnswerableRepository.findById(answerableId);
        if (optionalMRCAnswerable.isEmpty()) {
            return optionalMRCAnswerable.map(assignableMapper::map);
        }
        // Se lo trovo lo salvo...
        var answerable = optionalMRCAnswerable.get();
        // Creo un item e gli imposto come padre l'elemento trovato
        var answItem = MRCAnswerableItem.builder()
                .mrcAnswerable(answerable)
                .choice("")
                .solution(0).build();
        // Salvo il risultato
        mrcAnswerableItemRepository.save(answItem);
        // Riottengo l'oggetto
        return mrcAnswerableRepository.findById(answerableId).map(assignableMapper::map);
    }
}
