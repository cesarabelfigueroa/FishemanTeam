package CORE;

public class Place {
    private String id;
    private String name;
    private String idcommunity;

    public Place() {
    }

    public Place(String id, String name, String idcommunity) {
        this.id = id;
        this.name = name;
        this.idcommunity = idcommunity;
    }
    
    public Place(String name, String idcommunity) {
        this.name = name;
        this.idcommunity = idcommunity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getIdcommunity() {
        return idcommunity;
    }

    public void setIdcommunity(String idcommunity) {
        this.idcommunity = idcommunity;
    }

    public void setName(String name) {
        this.name = name;
    }
}