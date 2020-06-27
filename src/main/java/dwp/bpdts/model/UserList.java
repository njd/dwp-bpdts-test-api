package dwp.bpdts.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserList {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserList() {
        this.users = new ArrayList<>();
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return users.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public int size() {
        return users.size();
    }
}
