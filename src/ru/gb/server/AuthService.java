package ru.gb.server;

import ru.gb.db.User;
import ru.gb.db.UserService;

import java.util.Optional;

public class AuthService {

    public Optional<User> findUserByLoginAndPassword(String login, String password) {

        return UserService.findByLogin(login).stream()
                .filter(user -> user.getLogin().equals(login) &&
                        user.getPassword().equals(password))
                .findFirst();
    }

}
