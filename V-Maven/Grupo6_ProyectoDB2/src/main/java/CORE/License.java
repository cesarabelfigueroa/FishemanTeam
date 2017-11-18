package CORE;

public class License {

    private String id;
    private String name;
    private double price;
    private String idPlace;
    private String idCommunity;

    public License(String name, double price, String idPlace, String idCommunity) {
        this.name = name;
        this.price = price;
        this.idPlace = idPlace;
        this.idCommunity = idCommunity;
    }

    public License(String id, String name, double price, String idPlace, String idCommunity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idPlace = idPlace;
        this.idCommunity = idCommunity;
    }

    public License(int price, String idPlace, String idCommunity) {
        this.price = price;
        this.idPlace = idPlace;
        this.idCommunity = idCommunity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(String idPlace) {
        this.idPlace = idPlace;
    }

    public String getIdCommunity() {
        return idCommunity;
    }

    public void setIdCommunity(String idCommunity) {
        this.idCommunity = idCommunity;
    }

    @Override
    public String toString() {
        return name;
    }

}
