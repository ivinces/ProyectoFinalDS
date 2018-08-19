package Model;
import java.util.*;

/**
 * 
 */
public class RefrigeradoraDurex extends LineaBlancaAF {

    public RefrigeradoraDurex(String id, String articulo, int cantidadVentas, float montoTotalVentas) {
        super(id, articulo, cantidadVentas, montoTotalVentas);
    }

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