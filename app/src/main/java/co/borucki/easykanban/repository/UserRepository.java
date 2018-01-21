package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.model.User;

public interface UserRepository {
    void saveUser(User user);

    User getUserById(long id);

    void saveUser(List<User> users);

    List<User> getAllUsers();
}
