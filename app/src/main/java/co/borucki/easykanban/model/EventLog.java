package co.borucki.easykanban.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "event_log")
public class EventLog {
    @DatabaseField(columnName = "id", generatedId = true)
    private long id;
    @DatabaseField(columnName = "time_stamp")
    private String timeStamp;
    @DatabaseField(columnName = "user_id")
    private long userId;
    @DatabaseField(columnName = "event_name")
    private String eventName;
    @DatabaseField(columnName = "tag")
    private String tag;

    public EventLog() {
    }

    public EventLog(long id, String timeStamp, long userId, String eventName, String tag) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.userId = userId;
        this.eventName = eventName;
        this.tag = tag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", timeStamp='" + timeStamp + '\'' +
                ", userId=" + userId +
                ", eventName='" + eventName + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
