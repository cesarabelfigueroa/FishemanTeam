package CORE;

public class Place {
    private int id;
    private String name;
    private Community community;

    public Place() {
    }

    public Place(int id, String name, Community community) {
        this.id = id;
        this.name = name;
         this.community = community;
    }
    
    public Place(String name, Community community) {
        this.name = name;
         this.community = community;
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

    public Community getIdCommunity() {
        return community;
    }

    public void setIdCommunity(Community community) {
         this.community = community;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
