package Model;
import java.util.*;

/**
 * 
 */
public class Lavadora extends LineaBlanca {
    LineaBlanca lb;
    /**
     * Default constructor
     */
    public Lavadora(){
        lb.setNombre("Lavadora");
    }

    public LineaBlanca getLb() {
        return lb;
    }

    public void setLb(LineaBlanca lb) {
        this.lb = lb;
    }
    
    

}