package dwp.bpdts.service;

import dwp.bpdts.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    public List<User> getUsersInOrNearLondon() {

        List<User> users = new ArrayList<>();
        log.debug("getUsersInOrNearLondon returning {} users", users.size());

        return users;
    }
}
