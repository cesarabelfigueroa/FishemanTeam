package CORE;

public class Place {

    private String _id;
    private String name;
    private String idComunity;

    public Place(String _id, String name, String idComunity) {
        this._id = _id;
        this.name = name;
        this.idComunity = idComunity;
    }

    public String getIdComunity() {
        return idComunity;
    }

    public void setIdComunity(String _idComunity) {
        this.idComunity = _idComunity;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
