package CORE;

import java.util.ArrayList;


public class Bait {
    private String id;
    private String name;
    private String type;
    private String classification;
    private String color;
    private int size;
    private double price;
    private ArrayList<Material> materials;
    private String group;
    private Company company;

    public Bait() {
    }

    public Bait(String id, String name, String type, String classification, String color, int size, double price, ArrayList<Material> materials, String group, Company company) {
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
    
    public Bait(String id, String name, String type, String classification, String color, int size, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.classification = classification;
        this.color = color;
        this.size = size;
        this.price = price;
        this.materials = new ArrayList();
    }
    
    public Bait(String name, String type, String color, int size, double price,String group, Company company) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.size = size;
        this.price = price;
        this.group = group;
        this.company = company;
        this.materials = new ArrayList();
    }
    public Bait(String name,String type,String classification ,String color, int size, double price,ArrayList<Material> materials,String group, Company company) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.size = size;
        this.classification = classification;
        this.price = price;
        this.group = group;
        this.company = company;
        this.materials = materials;
    }
    public Bait(String id, String name, String type, String classification, String color, int size, double price, String group, Company company) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.classification = classification;
        this.color = color;
        this.size = size;
        this.price = price;
        this.group = group;
        this.company = company;
    }

    public Bait(String name, String type, String classification, String color, int size, double price, ArrayList<Material> materials) {
        this.name = name;
        this.type = type;
        this.classification = classification;
        this.color = color;
        this.size = size;
        this.price = price;
        this.materials = materials;
    }

    public Bait(String id, String name, String type, String classification, String color, int size, double price, ArrayList<Material> materials) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.classification = classification;
        this.color = color;
        this.size = size;
        this.price = price;
        this.materials = materials;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return name + ", Tipo: " + type;
    }
    
    
    
}
