package co.borucki.easykanban.dto;

public class IncomingMessageDTO {
    private long id;
    private String subject;
    private String from;
    private String contents;

    public IncomingMessageDTO() {
    }

    public IncomingMessageDTO(long id, String subject, String from, String contents) {
        this.id = id;
        this.subject = subject;
        this.from = from;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
