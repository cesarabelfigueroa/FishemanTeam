package CORE;

import java.util.ArrayList;


public class Shop {
    private String id;
    private String name;
    private ArrayList<Bait> sales = new ArrayList();

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }
    
    public Shop(String id, String name) {
        this.id = id;
        this.name = name;
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

    public ArrayList<Bait> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Bait> sales) {
        this.sales = sales;
    }

}