package team.exploding.kisabackenddb.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import team.exploding.kisabackenddb.exceptions.UnrecognizedUserException;
import team.exploding.kisabackenddb.model.Owned;
import team.exploding.kisabackenddb.model.security.KisaUserDetails;

@Service
public class UserCheckService {
    public boolean isAuthor(Owned authored) {
        System.out.println("security context: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof KisaUserDetails) {
            return authored.getOwner().equals(((KisaUserDetails) principal).getUsername());
        } else return false;

    }

    public String getCurrentUserName() throws UnrecognizedUserException {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.equals("anonymousUser")) return "anonymousUser";
        if (principal instanceof KisaUserDetails) {
            return ((KisaUserDetails) principal).getUsername();
        }
        throw new UnrecognizedUserException("Unknown user");
    }

    public String getUserNameOrElseThrowException() throws HttpClientErrorException {
        try {
            return this.getCurrentUserName();
        } catch (UnrecognizedUserException e) {
            System.err.println("Custom authentication error: user not present");
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }
}
