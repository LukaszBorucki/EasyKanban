package co.borucki.easykanban.statics;

import co.borucki.easykanban.model.User;
import co.borucki.easykanban.repository.UserRepository;
import co.borucki.easykanban.repository.UserRepositoryImpl;

public class SampleData {


    public static void loadUsers() {
        UserRepository mRepository = UserRepositoryImpl.getInstance();
        mRepository.saveUser(new User(1, "Jan", "Nowak", "1234", false, 15,"2015-12-14 09:08:12", 10 ));
        mRepository.saveUser(new User(2, "Sebek", "Kowalski", "1234", false, 15,"2015-12-14 09:08:12", 10 ));
        mRepository.saveUser(new User(3, "Antek", "Niemowa", "1234", false, 15,"2015-12-14 09:08:12", 10 ));
    }
}
