package Model;
import java.util.*;

/**
 * 
 */
public class Cocina extends Articulo {
    public boolean induccion;
    Articulo lb;
    /**
     * Default constructor
     */
    public Cocina() {
        this.induccion=true;
        super.setNombre("Cocina");
    }

    public Cocina(String string, String string0, int parseInt, float parseFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}