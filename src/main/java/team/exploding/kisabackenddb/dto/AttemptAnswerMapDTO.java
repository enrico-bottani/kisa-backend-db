package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttemptAnswerMapDTO {
    private long id;
    private boolean closed;
    private List<MRCChoosenItemDTO_IDOnly> mrcChoosenItems;

}
