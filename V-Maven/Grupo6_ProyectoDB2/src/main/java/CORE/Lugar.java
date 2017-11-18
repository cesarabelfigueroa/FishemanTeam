package CORE;

public class Lugar {
    private int id;
    private String nombre;
    private String idComunidad;

    public Lugar() {
    }

    public Lugar(int id, String nombre, String idComunidad) {
        this.id = id;
        this.nombre = nombre;
        this.idComunidad = idComunidad;
    }
    
    public Lugar(String nombre, String idComunidad) {
        this.nombre = nombre;
        this.idComunidad = idComunidad;
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

    public String getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(String idComunidad) {
        this.idComunidad = idComunidad;
    }

    @Override
    public String toString() {
        return "Lugar{" + "id=" + id + ", nombre=" + nombre + ", idComunidad=" + idComunidad + '}';
    }
    
    
}
