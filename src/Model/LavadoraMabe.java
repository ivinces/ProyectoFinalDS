package Model;
import java.util.*;

/**
 * 
 */
public class LavadoraMabe extends LineaBlancaAF {

    /**
     * Default constructor
     */
    public LavadoraMabe() {
    }

    @Override
    public LineaBlanca CrearArticulo() {
        return new Lavadora();
    }

    @Override
    public Marca AsignarMarca() {
        return new Mabe();
    }


}