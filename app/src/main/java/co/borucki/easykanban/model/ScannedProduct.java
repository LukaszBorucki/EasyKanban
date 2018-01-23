package co.borucki.easykanban.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "scanned_product")
public class ScannedProduct {
    @DatabaseField(columnName = "id", generatedId = true)
    private long id;
    @DatabaseField(columnName = "product_id")
    private String productId;
    @DatabaseField(columnName = "quantity")
    private int quantity;
    @DatabaseField(columnName = "time_stamp")
    private String timeStamp;
    @DatabaseField(columnName = "scanned_type")
    private String type;

    public ScannedProduct() {
    }

    public ScannedProduct(long id, String productId, int quantity, String timeStamp, String type) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.timeStamp = timeStamp;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ">>" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", timeStamp='" + timeStamp + '\'' +
                ", type='" + type + '\'' +
                "<<";
    }
}
