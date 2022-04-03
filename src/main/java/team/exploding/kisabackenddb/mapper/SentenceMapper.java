package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.dto.radio.RadioGroupDTO;
import team.exploding.kisabackenddb.model.sentence.Sentence;

import java.util.stream.Collectors;

@Component
public class SentenceMapper {
    public SentenceDTO map(Sentence sentenceDTO) {
        return SentenceDTO.builder().id(sentenceDTO.getId())
                .strings(sentenceDTO.getStrings())
                .radios(sentenceDTO.getRadioGroups().stream()
                        .map(RadioGroupDTO::new).collect(Collectors.toList()))
                .build();
    }
    public Sentence override(Sentence original, SentenceDTO sentence) {
        original.setStrings(sentence.getStrings());
        return original;
    }
}
