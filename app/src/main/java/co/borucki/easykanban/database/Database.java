package co.borucki.easykanban.database;

import java.util.List;

import co.borucki.easykanban.model.User;

public interface Database {
    void saveUser(User user);

    User getUserById(long id);

    void saveUsers(List<User> users);

    List<User> getAllUsers();
}
