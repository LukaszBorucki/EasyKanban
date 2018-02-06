package co.borucki.easykanban.dto;

public class ProductDTO {
    private String productId;
    private String photo;
    private String description;
    private int rackNo;
    private int rackShelfNo;
    private int rackShelfRowNo;
    private String producer;
    private String unit;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String photo, String description, int rackNo
            , int rackShelfNo, int rackShelfRowNo, String producer, String unit) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
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
