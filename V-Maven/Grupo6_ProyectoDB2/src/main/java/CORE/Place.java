package CORE;

public class Place {
    private int id;
    private String name;
    private String idcommunity;

    public Place() {
    }

    public Place(int id, String name, String idcommunity) {
        this.id = id;
        this.name = name;
        this.idcommunity = idcommunity;
    }
    
    public Place(String name, String idcommunity) {
        this.name = name;
        this.idcommunity = idcommunity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCommunity() {
        return idcommunity;
    }

    public void setIdCommunity(String idcommunity) {
        this.idcommunity = idcommunity;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
