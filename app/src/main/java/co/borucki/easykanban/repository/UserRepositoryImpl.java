package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.model.User;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl mInstance = new UserRepositoryImpl();
    private final Database mDatabase;

    private UserRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static UserRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveUser(User user) {
        mDatabase.saveUser(user);

    }

    @Override
    public User getUserById(long id) {
        return mDatabase.getUserById(id);
    }

    @Override
    public void saveUser(List<User> users) {
        mDatabase.saveUsers(users);
    }

    @Override
    public List<User> getAllUsers() {
        return mDatabase.getAllUsers();
    }
}
