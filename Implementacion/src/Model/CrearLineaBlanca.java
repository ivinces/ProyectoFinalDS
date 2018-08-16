package Model;
import java.util.*;

/**
 * 
 */
public class CrearLineaBlanca {

    /**
     * Default constructor
     * @param LineaBlancaAF
     */
    public CrearLineaBlanca(LineaBlancaAF LineaBlancaAF) {
        Marca marca=LineaBlancaAF.AsignarMarca();
        LineaBlanca producto=LineaBlancaAF.CrearArticulo();
        marca.colocarMarca(producto);
    }


}