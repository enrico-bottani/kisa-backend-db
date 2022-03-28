package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.model.sentence.Sentence;

@Component
public class SentenceMapper {
    public SentenceDTO map(Sentence sentenceDTO) {
        return SentenceDTO.builder().id(sentenceDTO.getId())
                .strings(sentenceDTO.getStrings()).build();
    }
}
