package CORE;

import java.util.ArrayList;

public class License {

    private String id;
    private String name;
    private double price;
    private Place place;
    private Community community;
    private ArrayList<Fish> fishes;

    public License(String id, String name, double price, Place place, Community community, ArrayList<Fish> fishes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.place = place;
        this.community = community;
        this.fishes = fishes;
    }

    public License(String name, double price, Place place, Community community, ArrayList<Fish> fishes) {
        this.name = name;
        this.price = price;
        this.place = place;
        this.community = community;
        this.fishes = fishes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public ArrayList<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(ArrayList<Fish> fishes) {
        this.fishes = fishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

}
