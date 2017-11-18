
package CORE;


public class AffiliateTest {
    private String name;

    public AffiliateTest() {
        
    }

    public AffiliateTest(String name) {
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