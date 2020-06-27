package dwp.bpdts.controller;

import dwp.bpdts.model.User;
import dwp.bpdts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class LondonUsersRestController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/london/users")
    public List<User> getLondonUsers() {

        List<User> londonUsers = userService.getUsersInOrNearLondon();
        log.info("Returning {} London users", londonUsers.size());

        return new ArrayList<User>();
    }

}
