package co.borucki.easykanban.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "product")
public class Product {
    @DatabaseField(columnName = "product_id", id = true)
    private String productId;
    @DatabaseField(columnName = "photo", dataType = DataType.SERIALIZABLE)
    private byte[] photo;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "rack_no")
    private int rackNo;
    @DatabaseField(columnName = "rack_shelf_no")
    private int rackShelfNo;
    @DatabaseField(columnName = "rack_shelf_row_no")
    private int rackShelfRowNo;
    @DatabaseField(columnName = "producer")
    private String producer;
    @DatabaseField(columnName = "unit")
    private String unit;

    public Product() {
    }

    public Product(String productId, byte[] photo, String description, int rackNo, int rackShelfNo, int rackShelfRowNo, String producer, String unit) {
        this.productId = productId;
        this.photo = photo;
        this.description = description;
        this.rackNo = rackNo;
        this.rackShelfNo = rackShelfNo;
        this.rackShelfRowNo = rackShelfRowNo;
        this.producer = producer;
        this.unit = unit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRackNo() {
        return rackNo;
    }

    public void setRackNo(int rackNo) {
        this.rackNo = rackNo;
    }

    public int getRackShelfNo() {
        return rackShelfNo;
    }

    public void setRackShelfNo(int rackShelfNo) {
        this.rackShelfNo = rackShelfNo;
    }

    public int getRackShelfRowNo() {
        return rackShelfRowNo;
    }

    public void setRackShelfRowNo(int rackShelfRowNo) {
        this.rackShelfRowNo = rackShelfRowNo;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
