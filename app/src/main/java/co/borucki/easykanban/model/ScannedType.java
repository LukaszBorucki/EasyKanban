package co.borucki.easykanban.model;


public enum ScannedType {
    USED("used"),
    RECEIVED("received"),
    STOCKTAKING("stocktaking");

    private String type;

    ScannedType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
