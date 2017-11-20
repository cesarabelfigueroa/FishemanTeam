package CORE;

public class Place {
    private String id;
    private String name;
    private Community community;

    public Place() {
    }
    
    public Place(String id) {
        this.id = id;
    }

    public Place(String id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public Place(String id, String name, Community community) {
        this.id = id;
        this.name = name;
        this.community = community;
    }
    
    public Place(String name, Community community) {
        this.name = name;
         this.community = community;
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

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Community getCommunity() {
        return community;
    }

  
    public void setName(String name) {
        this.name = name;
    }
}