package CORE;

import java.util.ArrayList;

public class Fish {
    private String id;
    private String name;
    private ArrayList<Bait>  baits;

    public Fish() {
    }

    public Fish(String id, String name) {
        this.id = id;
        this.name = name;
        this.baits = new ArrayList();
    }

    
    public Fish(String id, String name, ArrayList<Bait> baits) {
        this.id = id;
        this.name = name;
        this.baits = baits;
    }

    public Fish(String name, ArrayList<Bait> baits) {
        this.name = name;
        this.baits = baits;
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

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bait> getBaits() {
        return baits;
    }

    public void setBaitID(ArrayList<Bait> baits) {
        this.baits = baits;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
