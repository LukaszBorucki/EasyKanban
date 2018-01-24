package co.borucki.easykanban.repository;

import co.borucki.easykanban.model.Product;

public interface ProductRepository {
    Product findProductById(String id);

    void saveProduct(Product product);
}
