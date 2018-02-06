package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.model.Product;

public interface ProductRepository {
    Product findProductById(String id);

    void saveProduct(Product product);

    void saveProduct(List<Product> products);

    void removeAll();
}
