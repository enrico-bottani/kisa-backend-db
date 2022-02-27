package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.AttemptAnswerMapDTO;
import team.exploding.kisabackenddb.dto.MRCChoosenItemDTO_IDOnly;
import team.exploding.kisabackenddb.model.Attempt;

import java.util.stream.Collectors;

@Component
public class AttemptMapper {
    public AttemptAnswerMapDTO mapAsAnswSheet(Attempt attempt) {
        return AttemptAnswerMapDTO.builder().id(attempt.getId()).closed(attempt.isClosed())
                .mrcChoosenItems(attempt.mrcChoosenItems.stream()
                        .map(this::getMRCChoosenItemDTO)
                        .collect(Collectors.toList())).build();
    }

    private MRCChoosenItemDTO_IDOnly getMRCChoosenItemDTO(team.exploding.kisabackenddb.model.MRCChoosenItem choosenItem) {
        return MRCChoosenItemDTO_IDOnly.builder()
                .answerable_item_id(choosenItem.getMrcAnswerableItem().getId()).build();
    }
}
