package CORE;

import java.util.ArrayList;

public class Affiliate {
    private String id;
    private String name;
    private ArrayList<License> licenses;

    public Affiliate() {
    }

    public Affiliate(String id, String name, ArrayList<License> licenses) {
        this.id = id;
        this.name = name;
        this.licenses = licenses;
    }
    
    public Affiliate(String name, ArrayList<License> licenses) {
        this.name = name;
        this.licenses = licenses;
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

    public ArrayList<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(ArrayList<License> licenses) {
        this.licenses = licenses;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
