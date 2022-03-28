package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.SentenceDTO;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.model.sentence.Sentence;
import team.exploding.kisabackenddb.model.series.Series;

@Component
public class SentenceMapper {
    public SentenceDTO map(Sentence sentenceDTO) {
        return SentenceDTO.builder().id(sentenceDTO.getId())
                .strings(sentenceDTO.getSentences()).build();
    }
}
