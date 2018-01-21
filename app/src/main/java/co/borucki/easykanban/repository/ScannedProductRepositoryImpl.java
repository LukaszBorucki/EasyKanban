package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.model.ScannedProduct;

public class ScannedProductRepositoryImpl implements ScannedProductRepository {
    private static ScannedProductRepositoryImpl mInstance = new ScannedProductRepositoryImpl();
    private final Database mDatabase;

    public static ScannedProductRepositoryImpl getInstance() {
        return mInstance;
    }

    private ScannedProductRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    @Override
    public List<ScannedProduct> getAllScannedProductByType(String type) {
        return mDatabase.getAllScannedProductByType(type);
    }

    @Override
    public long countScannedProductByType(String type) {
        return mDatabase.countScannedProductByType(type);
    }
}
