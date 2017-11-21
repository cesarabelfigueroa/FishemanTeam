package CORE;

public class Community {

    private String id;
    private String name;

    public Community(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Community(String name, Boolean bool){
        this.name = name;
    }
    public Community(String id) {
        this.id = id;
    }

    public Community() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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