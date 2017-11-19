package CORE;

import java.util.ArrayList;

public class Fish {
    private int id;
    private String name;
    private ArrayList<Bait>  baits;

    public Fish() {
    }

    public Fish(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public Fish(int id, String name, ArrayList<Bait> baits) {
        this.id = id;
        this.name = name;
        this.baits = baits;
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
