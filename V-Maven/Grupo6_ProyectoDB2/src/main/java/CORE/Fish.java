package CORE;

import java.util.ArrayList;

public class Fish {
    private int id;
    private String name;
    private ArrayList<String>  baitID;

    public Fish() {
    }

    public Fish(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public Fish(int id, String name, ArrayList<String> baitID) {
        this.id = id;
        this.name = name;
        this.baitID = baitID;
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

    public ArrayList<String> getBaitID() {
        return baitID;
    }

    public void setBaitID(ArrayList<String> baitID) {
        this.baitID = baitID;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
