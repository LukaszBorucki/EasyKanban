package co.borucki.easykanban.repository;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.model.Product;

public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepositoryImpl mInstance = new ProductRepositoryImpl();
    private final Database mDatabase;

    private ProductRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static ProductRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public Product findProductById(String id) {
        return mDatabase.findProductById(id);
    }

    @Override
    public void saveProduct(Product product) {
        mDatabase.saveProduct(product);
    }
}
