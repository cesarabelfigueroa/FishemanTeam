package CORE;

import java.util.ArrayList;


public class Comercio {
    private String id;
    private String nombre;
    private ArrayList<Cebo> cebosVenta;

    public Comercio() {
    }
    
    
    public Comercio(String id, String nombre, ArrayList<Cebo> cebosVenta) {
        this.id = id;
        this.nombre = nombre;
        this.cebosVenta = cebosVenta;
    }
    
    public Comercio(String nombre, ArrayList<Cebo> cebosVenta) {
        this.nombre = nombre;
        this.cebosVenta = cebosVenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cebo> getCebosVenta() {
        return cebosVenta;
    }

    public void addCebosVenta(Cebo add) {
        this.cebosVenta.add(add);
    }

    @Override
    public String toString() {
        return "Comercio{" + "id=" + id + ", nombre=" + nombre + ", cebosVenta=" + cebosVenta + '}';
    }
    
    
    
}
