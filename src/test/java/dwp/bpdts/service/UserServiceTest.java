package dwp.bpdts.service;

import dwp.bpdts.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsersInOrNearLondon() {
        List<User> users = userService.getUsersInOrNearLondon();
        assertEquals(0, users.size());
    }
}