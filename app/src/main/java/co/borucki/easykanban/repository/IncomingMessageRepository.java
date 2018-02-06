package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.model.IncomingMessage;

public interface IncomingMessageRepository {
    void saveMessage(IncomingMessage message);

    IncomingMessage getMessageById(long id);

    void saveMessages(List<IncomingMessage> messages);

    List<IncomingMessage> getAllMessages();

    long countUnreadMessages();

    long getLastMessageId();

    void removeAll();
}
