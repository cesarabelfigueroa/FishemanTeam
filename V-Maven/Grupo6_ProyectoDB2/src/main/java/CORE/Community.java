package CORE;

public class Community {
    private String id;
    private String nombre;

    public Community(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Community(String nombre) {
        this.nombre = nombre;
    }

    public Community() {
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

    @Override
    public String toString() {
        return "Comunidad{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
