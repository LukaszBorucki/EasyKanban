package co.borucki.easykanban.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "message")
public class IncomingMessage {
    @DatabaseField(columnName = "id", id = true)
    private long id;
    @DatabaseField(columnName = "message_subject")
    private String subject;
    @DatabaseField(columnName = "message_from")
    private String from;
    @DatabaseField(columnName = "message_received_date_time")
    private String receivedDate;
    @DatabaseField(columnName = "message_is_read")
    private boolean isRead;
    @DatabaseField(columnName = "message_contents")
    private String contents;
    @DatabaseField(columnName = "who_read_first")
    private long whoReadFirstMessage;
    @DatabaseField(columnName = "is_hidden")
    private boolean isHidden;
    @DatabaseField(columnName = "who_hide_message")
    private long whoHideMessage;



    public IncomingMessage() {
    }

    public IncomingMessage(long id, String subject, String from, String receivedDate, boolean isRead, String contents) {
        this.id = id;
        this.subject = subject;
        this.from = from;
        this.receivedDate = receivedDate;
        this.isRead = isRead;
        this.contents = contents;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public long getWhoReadFirstMessage() {
        return whoReadFirstMessage;
    }

    public void setWhoReadFirstMessage(long whoReadFirstMessage) {
        this.whoReadFirstMessage = whoReadFirstMessage;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public long getWhoHideMessage() {
        return whoHideMessage;
    }

    public void setWhoHideMessage(long whoHideMessage) {
        this.whoHideMessage = whoHideMessage;
    }
}
