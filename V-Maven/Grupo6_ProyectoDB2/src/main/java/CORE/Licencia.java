package CORE;

public class Licencia {
    private int id;
    private double precio;
    private String idLugar;
    private String idComunidad;

    public Licencia() {
    }

    public Licencia(int id, int precio, String idLugar, String idComunidad) {
        this.id = id;
        this.precio = precio;
        this.idLugar = idLugar;
        this.idComunidad = idComunidad;
    }
    
    public Licencia(int precio, String idLugar, String idComunidad) {
        this.precio = precio;
        this.idLugar = idLugar;
        this.idComunidad = idComunidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(String idComunidad) {
        this.idComunidad = idComunidad;
    }

    @Override
    public String toString() {
        return "Lugar{" + "id=" + id + ", precio=" + precio + ", idLugar=" + idLugar + ", idComunidad=" + idComunidad + '}';
    }
    
    
}
