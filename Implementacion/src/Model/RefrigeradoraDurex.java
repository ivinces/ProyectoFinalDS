package Model;
import java.util.*;

/**
 * 
 */
public class RefrigeradoraDurex extends LineaBlancaAF {

    /**
     * Default constructor
     */
    public RefrigeradoraDurex() {
    }

    @Override
    public LineaBlanca CrearArticulo() {
        return new Refrigeradora();
    }

    @Override
    public Marca AsignarMarca() {
        return new Durex();
    }

    /**
     * @return
     */
    
}