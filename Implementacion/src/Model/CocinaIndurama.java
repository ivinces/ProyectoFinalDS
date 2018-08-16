package Model;
import java.util.*;

/**
 * 
 */
public class CocinaIndurama extends LineaBlancaAF {

    /**
     * Default constructor
     */
    public CocinaIndurama() {
    }

    @Override
    public LineaBlanca CrearArticulo() {
        return new Cocina();
    }

    @Override
    public Marca AsignarMarca() {
        return new Indurama();
    }

}