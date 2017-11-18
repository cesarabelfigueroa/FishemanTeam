
package CORE;


public class Affiliate {
    private String name;

    public Affiliate() {
        
    }

    public Affiliate(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Affiliate{" + "name=" + name + '}';
    }
    
}