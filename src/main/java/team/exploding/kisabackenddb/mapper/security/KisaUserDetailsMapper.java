package team.exploding.kisabackenddb.mapper.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import team.exploding.kisabackenddb.dto.KisaUserDatailsEntityDTO;
import team.exploding.kisabackenddb.model.security.KisaUserDatailsEntity;
import team.exploding.kisabackenddb.model.security.KisaUserDetails;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class KisaUserDetailsMapper {
    public KisaUserDetails map(KisaUserDatailsEntity kisaUserDatailsEntity){
        return KisaUserDetails.builder()
                .username(kisaUserDatailsEntity.getUserName())
                .password(kisaUserDatailsEntity.getPassword())
                .active(kisaUserDatailsEntity.isActive())
                .authorities(Arrays.stream(kisaUserDatailsEntity.getRoles().split(","))
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .build();
    }
    public KisaUserDatailsEntityDTO mapToDTO(KisaUserDatailsEntity kisaUserDatailsEntity){
        return KisaUserDatailsEntityDTO.builder().userName(kisaUserDatailsEntity.getUserName()).build();
    }
}
