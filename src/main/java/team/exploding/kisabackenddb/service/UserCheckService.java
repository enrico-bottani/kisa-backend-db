package team.exploding.kisabackenddb.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import team.exploding.kisabackenddb.model.Authored;
import team.exploding.kisabackenddb.model.security.KisaUserDetails;

import java.util.Optional;

@Service
public class UserCheckService {
    public boolean isAuthor(Authored authored) {
        System.out.println("security context: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof KisaUserDetails) {
            return authored.recoverAuthorUserName().equals(((KisaUserDetails) principal).getUsername());
        } else return false;

    }

    public Optional<String> getAuthor() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof KisaUserDetails) {
            return Optional.of(((KisaUserDetails) principal).getUsername());
        } else return Optional.empty();
    }
    public String getUserNameOrElseThrowException() throws HttpClientErrorException {
        var user = this.getAuthor();
        if (user.isEmpty()){
            System.err.println("Custom authentication error: user not present");
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
        return user.get();
    }
}
