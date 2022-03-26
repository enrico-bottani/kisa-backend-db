package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.dto.SeriesDTO;
import team.exploding.kisabackenddb.mapper.SeriesMapper;
import team.exploding.kisabackenddb.mapper.security.KisaUserDetailsMapper;
import team.exploding.kisabackenddb.model.security.KisaUserDatailsEntity;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KisaUserDetailsService implements UserDetailsService {

    @Autowired
    KisaUserDatailsEntityRepository kisaUserDatailsEntityRepository;
    @Autowired
    KisaUserDetailsMapper kisaUserDetailsMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    SeriesMapper seriesMapper;



    public KisaUserDatailsEntity saveUsername(String username, String password) {
        return kisaUserDatailsEntityRepository.save(KisaUserDatailsEntity.builder()
                .userName(username).password(passwordEncoder.encode(password))
                .active(true).roles("ROLE_TEACHER").build());
    }

    public List<SeriesDTO> findSeriesByUserName(String userName){
        var user = kisaUserDatailsEntityRepository.findByUserName(userName);
        if (user.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user.get().getSeries().stream().map(seriesMapper::map).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity =
                kisaUserDatailsEntityRepository.findByUserName(username);

        return kisaUserDetailsMapper.map(userEntity
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found")));
    }



}
