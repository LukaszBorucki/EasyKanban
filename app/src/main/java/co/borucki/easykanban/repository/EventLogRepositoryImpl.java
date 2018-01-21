package co.borucki.easykanban.repository;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.model.EventLog;

public class EventLogRepositoryImpl implements EventLogRepository {
    private static EventLogRepositoryImpl mInstance = new EventLogRepositoryImpl();
    private final Database mDatabase;

    private EventLogRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static EventLogRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveEventLog(EventLog eventLog) {
        mDatabase.saveEventLog(eventLog);
    }
}
