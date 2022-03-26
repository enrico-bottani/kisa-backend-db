package team.exploding.kisabackenddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import team.exploding.kisabackenddb.model.Owned;
import team.exploding.kisabackenddb.repository.KisaUserDatailsEntityRepository;

@Component
public class ServiceUtils {

    @Autowired
    KisaUserDatailsEntityRepository userDetailsRepository;

    public void checkOwnership(Owned ownedResource, String userName) {
        var user = userDetailsRepository.findByUserName(userName);
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        if (!ownedResource.getOwner().equals(userName)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
