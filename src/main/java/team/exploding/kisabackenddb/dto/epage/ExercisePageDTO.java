package team.exploding.kisabackenddb.dto.epage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ExercisePageDTO {
    Long id;
    int position=0;
    long _exerciseId;
}
