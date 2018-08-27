package Model;
import java.util.*;

/**
 * 
 */
public class Lavadora extends Articulo {
    Articulo lb;
    /**
     * Default constructor
     */
    public Lavadora(){
        super.setNombre("Lavadora");
    }

    public Lavadora(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Articulo getLb() {
        return lb;
    }

    public void setLb(Articulo lb) {
        this.lb = lb;
    }
    
    

}