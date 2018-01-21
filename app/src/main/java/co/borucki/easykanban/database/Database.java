package co.borucki.easykanban.database;

import java.util.List;

import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.model.User;

public interface Database {
    void saveUser(User user);

    User getUserById(long id);

    void saveUsers(List<User> users);

    List<User> getAllUsers();

    void saveMessage(IncomingMessage message);

    IncomingMessage getMessageById(long id);

    void saveMessages(List<IncomingMessage> messages);

    List<IncomingMessage> getAllMessages();

    long countUnreadMessages();


    void saveEventLog(EventLog eventLog);
}
