package co.borucki.easykanban.repository;

import co.borucki.easykanban.model.EventLog;

public interface EventLogRepository {
    void saveEventLog(EventLog eventLog);
}
