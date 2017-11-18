package CORE;

public class Pez {
    private int id;
    private String nombre;
    private Licencia capturaLic;
    private Cebo CapturaCebo;

    public Pez() {
    }

    public Pez(int id, String nombre, Licencia capturaLic, Cebo CapturaCebo) {
        this.id = id;
        this.nombre = nombre;
        this.capturaLic = capturaLic;
        this.CapturaCebo = CapturaCebo;
    }
    
    public Pez(String nombre, Licencia capturaLic, Cebo CapturaCebo) {
        this.nombre = nombre;
        this.capturaLic = capturaLic;
        this.CapturaCebo = CapturaCebo;
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

    public Licencia getCapturaLic() {
        return capturaLic;
    }

    public void setCapturaLic(Licencia capturaLic) {
        this.capturaLic = capturaLic;
    }

    public Cebo getCapturaCebo() {
        return CapturaCebo;
    }

    public void setCapturaCebo(Cebo CapturaCebo) {
        this.CapturaCebo = CapturaCebo;
    }

    @Override
    public String toString() {
        return "Pez{" + "id=" + id + ", nombre=" + nombre + ", capturaLic=" + capturaLic + ", CapturaCebo=" + CapturaCebo + '}';
    }
    
    
}
