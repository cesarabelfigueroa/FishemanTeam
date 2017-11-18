package CORE;

import java.util.ArrayList;


public class Cebo {
    private int id;
    private String nombre;
    private String tipo;
    private String clasificacion;
    private String color;
    private int tamaño;
    private int precio;
    private ArrayList<String> materiales;
    private String grupo;
    private String fabricante;

    public Cebo() {
    }

    public Cebo(int id, String nombre, String tipo, String clasificacion, String color, int tamaño, int precio, ArrayList<String> materiales, String grupo, String fabricante) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.clasificacion = clasificacion;
        this.color = color;
        this.tamaño = tamaño;
        this.precio = precio;
        this.materiales = materiales;
        this.grupo = grupo;
        this.fabricante = fabricante;
    }
    
    public Cebo(String nombre, String tipo, String clasificacion, String color, int tamaño, int precio, ArrayList<String> materiales, String grupo, String fabricante) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.clasificacion = clasificacion;
        this.color = color;
        this.tamaño = tamaño;
        this.precio = precio;
        this.materiales = materiales;
        this.grupo = grupo;
        this.fabricante = fabricante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<String> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<String> materiales) {
        this.materiales = materiales;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Cebo{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", clasificacion=" + clasificacion + ", color=" + color + ", tama\u00f1o=" + tamaño + ", precio=" + precio + ", materiales=" + materiales + ", grupo=" + grupo + ", fabricante=" + fabricante + '}';
    }
    
    
    
}
