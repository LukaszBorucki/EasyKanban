package co.borucki.easykanban.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.model.IncomingMessage;
import co.borucki.easykanban.model.User;

public class DatabaseOrmImpl extends OrmLiteSqliteOpenHelper implements Database {
    private static final String DATABASE_NAME = "EasyKanban";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<User, Integer> mUserDao;
    private RuntimeExceptionDao<IncomingMessage, Integer> mMessageDao;
    private RuntimeExceptionDao<EventLog, Integer> mEventLogDao;

    public DatabaseOrmImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mUserDao = getRuntimeExceptionDao(User.class);
        mMessageDao = getRuntimeExceptionDao(IncomingMessage.class);
        mEventLogDao = getRuntimeExceptionDao(EventLog.class);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, IncomingMessage.class);
            TableUtils.createTableIfNotExists(connectionSource, EventLog.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }

    //<User>
    @Override
    public void saveUser(User user) {
        mUserDao.createOrUpdate(user);
    }

    @Override
    public User getUserById(long id) {
        QueryBuilder<User, Integer> qb = mUserDao.queryBuilder();
        Where where = qb.where();
        try {
            where.like("id", id);
            return qb.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveUsers(List<User> users) {
        mUserDao.create(users);
    }

    @Override
    public List<User> getAllUsers() {
        return mUserDao.queryForAll();
    }

    //<User/>
    //<IncomingMessages>
    @Override
    public void saveMessage(IncomingMessage message) {
        mMessageDao.createOrUpdate(message);
    }

    @Override
    public IncomingMessage getMessageById(long id) {
        QueryBuilder<IncomingMessage, Integer> qb = mMessageDao.queryBuilder();
        Where where = qb.where();
        try {
            where.like("id", id);
            return qb.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveMessages(List<IncomingMessage> messages) {
        mMessageDao.create(messages);
    }

    @Override
    public List<IncomingMessage> getAllMessages() {
        return mMessageDao.queryForEq("is_hidden", false);
    }

    @Override
    public long countUnreadMessages() {
        long counter = 0;
        try {
            counter = mMessageDao.queryBuilder().where().eq("message_is_read", false).countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return counter;
    }

    //<IncomingMessages/>
    //<EventLog>

    @Override
    public void saveEventLog(EventLog eventLog) {
        mEventLogDao.create(eventLog);
    }

    //<EventLog/>
}
