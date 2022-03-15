package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.security.KisaUserDatailsEntity;
import team.exploding.kisabackenddb.model.security.KisaUserDetails;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;

@Service
public class KisaUserDetailsService implements UserDetailsService {

    @Autowired
    KisaUserDatailsEntityRepository kisaUserDatailsEntityRepository;

    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUsername(String username, String password){
        kisaUserDatailsEntityRepository.save(KisaUserDatailsEntity.builder()
                .userName(username).password(passwordEncoder.encode(password)).active(true).roles("ROLE_TEACHER").build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity =
                kisaUserDatailsEntityRepository.findByUserName(username);

        return kisaUserDetailsMapper.map(userEntity
                .orElseThrow(() -> new UsernameNotFoundException("Username "+username+" not found")));
    }


}
