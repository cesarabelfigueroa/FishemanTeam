package CORE;

public class Pez {
    private int id;
    private String nombre;
    private License capturaLic;
    private Bait CapturaCebo;

    public Pez() {
    }

    public Pez(int id, String nombre, License capturaLic, Bait CapturaCebo) {
        this.id = id;
        this.nombre = nombre;
        this.capturaLic = capturaLic;
        this.CapturaCebo = CapturaCebo;
    }
    
    public Pez(String nombre, License capturaLic, Bait CapturaCebo) {
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

    public License getCapturaLic() {
        return capturaLic;
    }

    public void setCapturaLic(License capturaLic) {
        this.capturaLic = capturaLic;
    }

    public Bait getCapturaCebo() {
        return CapturaCebo;
    }

    public void setCapturaCebo(Bait CapturaCebo) {
        this.CapturaCebo = CapturaCebo;
    }

    @Override
    public String toString() {
        return "Pez{" + "id=" + id + ", nombre=" + nombre + ", capturaLic=" + capturaLic + ", CapturaCebo=" + CapturaCebo + '}';
    }
    
    
}
