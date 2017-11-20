package CORE;

import java.util.ArrayList;


public class Shops {
    private String id;
    private String name;
    private ArrayList<Bait> sellingBait;

    public Shops() {
    }
    
    
    public Shops(String id, String name, ArrayList<Bait> sellingBait) {
        this.id = id;
        this.name = name;
        this.sellingBait = sellingBait;
    }
    
    public Shops(String name, ArrayList<Bait> sellingBait) {
        this.name = name;
        this.sellingBait = sellingBait;
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

    public ArrayList<Bait> getSellingBait() {
        return sellingBait;
    }

    public void addSellingBait(Bait add) {
        this.sellingBait.add(add);
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
