package CORE;

import java.util.ArrayList;


public class Bait {
    private int id;
    private String name;
    private String type;
    private String classification;
    private String color;
    private int size;
    private int price;
    private ArrayList<String> materials;
    private String group;
    private String company;

    public Bait() {
    }

    public Bait(int id, String name, String type, String classification, String color, int size, int price, ArrayList<String> materials, String group, String company) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.classification = classification;
        this.color = color;
        this.size = size;
        this.price = price;
        this.materials = materials;
        this.group = group;
        this.company = company;
    }
    
    public Bait(String name, String type, String classification, String color, int size, int price, ArrayList<String> materials, String group, String company) {
        this.name = name;
        this.type = type;
        this.classification = classification;
        this.color = color;
        this.size = size;
        this.price = price;
        this.materials = materials;
        this.group = group;
        this.company = company;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<String> materials) {
        this.materials = materials;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return name + ", Tipo: " + type;
    }
    
    
    
}
