package team.exploding.kisabackenddb.mapper;

import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.KUserDTO;
import team.exploding.kisabackenddb.model.KUser;

@Component
public class KUserMapper {
    public KUserDTO map(KUser kuser){
        return KUserDTO.builder().firstName(kuser.getFirstName()).build();
    }
}
