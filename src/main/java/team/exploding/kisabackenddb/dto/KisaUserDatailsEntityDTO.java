package team.exploding.kisabackenddb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KisaUserDatailsEntityDTO {
    Long id;
    String userName;
}
