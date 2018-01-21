package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.model.IncomingMessage;

public class IncomingMessageRepositoryImpl implements IncomingMessageRepository {
    private final Database mDatabase;
    private static IncomingMessageRepositoryImpl mInstance = new IncomingMessageRepositoryImpl();

    private IncomingMessageRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static IncomingMessageRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveMessage(IncomingMessage message) {
        mDatabase.saveMessage(message);
    }

    @Override
    public IncomingMessage getMessageById(long id) {
        return mDatabase.getMessageById(id);
    }

    @Override
    public void saveMessages(List<IncomingMessage> messages) {
        mDatabase.saveMessages(messages);
    }

    @Override
    public List<IncomingMessage> getAllMessages() {
        return mDatabase.getAllMessages();
    }

    @Override
    public long countUnreadMessages() {
        return mDatabase.countUnreadMessages();
    }

}
