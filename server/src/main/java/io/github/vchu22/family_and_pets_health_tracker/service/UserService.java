package io.github.vchu22.family_and_pets_health_tracker.service;

import io.github.vchu22.family_and_pets_health_tracker.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;
    public UserService() {
        userList = new ArrayList<>();
        User u1 = new User(1, "joe", "joe@email.com", "12345678abcd");
        User u2 = new User(2, "happy-family", "happy@family.com", "12345678abcd");
        User u3 = new User(3, "paw_house", "woof_meow@email.com", "12345678abcd");
        userList.addAll(Arrays.asList(u1,u2,u3));
    }
    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
