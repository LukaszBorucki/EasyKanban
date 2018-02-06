package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.model.EventLog;

public interface EventLogRepository {
    void saveEventLog(EventLog eventLog);

    void removeAll();

    List<EventLog> getAll();
}
