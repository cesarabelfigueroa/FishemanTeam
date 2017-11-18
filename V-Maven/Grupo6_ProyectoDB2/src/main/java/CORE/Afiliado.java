package CORE;

import java.util.ArrayList;

public class Afiliado {
    private String id;
    private String nombre;
    private ArrayList<Licencia> licencias;

    public Afiliado() {
    }

    public Afiliado(String id, String nombre, ArrayList<Licencia> licencias) {
        this.id = id;
        this.nombre = nombre;
        this.licencias = licencias;
    }
    
    public Afiliado(String nombre, ArrayList<Licencia> licencias) {
        this.nombre = nombre;
        this.licencias = licencias;
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

    public ArrayList<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(ArrayList<Licencia> licencias) {
        this.licencias = licencias;
    }

    @Override
    public String toString() {
        return "Afiliado{" + "id=" + id + ", nombre=" + nombre + ", licencias=" + licencias + '}';
    }
    
    
}
