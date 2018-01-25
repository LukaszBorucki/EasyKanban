package co.borucki.easykanban.repository;

import java.util.List;

import co.borucki.easykanban.model.ScannedProduct;

public interface ScannedProductRepository {
    List<ScannedProduct> getAllScannedProductByType(String type);

    long countScannedProductByType(String type);

    void save(ScannedProduct scannedProduct);

    void delete(ScannedProduct scannedProduct);

    void delete(List<ScannedProduct> scannedProducts);
}
