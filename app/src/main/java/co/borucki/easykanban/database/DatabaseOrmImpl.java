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
import co.borucki.easykanban.model.Product;
import co.borucki.easykanban.model.ScannedProduct;
import co.borucki.easykanban.model.User;

public class DatabaseOrmImpl extends OrmLiteSqliteOpenHelper implements Database {
    private static final String DATABASE_NAME = "EasyKanban";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<User, Integer> mUserDao;
    private RuntimeExceptionDao<IncomingMessage, Integer> mMessageDao;
    private RuntimeExceptionDao<EventLog, Integer> mEventLogDao;
    private RuntimeExceptionDao<ScannedProduct, Integer> mScannedProductDao;
    private RuntimeExceptionDao<Product, Integer> mProductDao;

    public DatabaseOrmImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mUserDao = getRuntimeExceptionDao(User.class);
        mMessageDao = getRuntimeExceptionDao(IncomingMessage.class);
        mEventLogDao = getRuntimeExceptionDao(EventLog.class);
        mScannedProductDao = getRuntimeExceptionDao(ScannedProduct.class);
        mProductDao = getRuntimeExceptionDao(Product.class);

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, IncomingMessage.class);
            TableUtils.createTableIfNotExists(connectionSource, EventLog.class);
            TableUtils.createTableIfNotExists(connectionSource, ScannedProduct.class);
            TableUtils.createTableIfNotExists(connectionSource, Product.class);

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
        if (mUserDao.queryForEq("id", user.getId()).size() == 0) {
            mUserDao.create(user);
        }
    }

    @Override
    public void saveUsers(List<User> users) {
        for (User user : users) {
            saveUser(user);
        }


    }

    @Override
    public void updateUser(User user) {
        mUserDao.createOrUpdate(user);
    }

    @Override
    public void updateUser(List<User> users) {
        for (User user : users) {
            mUserDao.update(user);
        }
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
    public List<User> getAllUsers() {
        return mUserDao.queryForEq("user_is_blocked", false);
    }

    @Override
    public void removeAllUser() {
        mUserDao.delete(mUserDao.queryForAll());
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

    @Override
    public long getLastMessageId() {
        List<IncomingMessage> incomingMessages = mMessageDao.queryForAll();
        if (incomingMessages.size() == 0) return 0;
        return incomingMessages.get(incomingMessages.size() - 1).getId();
    }

    @Override
    public void removeAllIncomingMessage() {
        mMessageDao.delete(mMessageDao.queryForAll());
    }
    //<IncomingMessages/>
    //<EventLog>

    @Override
    public List<EventLog> getAllEventLog() {
        return mEventLogDao.queryForAll();
    }

    @Override
    public void saveEventLog(EventLog eventLog) {
        mEventLogDao.create(eventLog);
    }

    @Override
    public void removeAllEventLog() {
        mEventLogDao.delete(mEventLogDao.queryForAll());
    }
//<EventLog/>
    //<ScannedProduct>

    @Override
    public List<ScannedProduct> getAllScannedProductByType(String type) {
        return mScannedProductDao.queryForEq("scanned_type", type);
    }

    @Override
    public long countScannedProductByType(String type) {
        long counter = 0;
        try {
            counter = mScannedProductDao.queryBuilder().where().eq("scanned_type", type).countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counter;
    }

    @Override
    public void save(ScannedProduct scannedProduct) {
        mScannedProductDao.create(scannedProduct);
    }

    @Override
    public void delete(ScannedProduct scannedProduct) {
        mScannedProductDao.delete(scannedProduct);
    }

    @Override
    public void delete(List<ScannedProduct> scannedProducts) {
        mScannedProductDao.delete(scannedProducts);
    }

    @Override
    public void removeAllScannedProduct() {
        mScannedProductDao.delete(mScannedProductDao.queryForAll());
    }
    //<ScannedProduct/>
    //<Product>

    @Override
    public Product findProductById(String id) {
        if (mProductDao.queryForEq("product_id", id).size() > 0)
            return mProductDao.queryForEq("product_id", id).get(0);
        else return null;
    }

    @Override
    public void saveProduct(Product product) {
        mProductDao.createOrUpdate(product);
    }

    @Override
    public void saveProduct(List<Product> products) {
        for (Product product : products) {
            saveProduct(product);
        }
    }

    @Override
    public void removeAllProduct() {
        mProductDao.delete(mProductDao.queryForAll());
    }


//<Product/>

}
