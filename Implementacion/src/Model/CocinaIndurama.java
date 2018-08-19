package Model;
import java.util.*;

/**
 * 
 */
public class CocinaIndurama extends LineaBlancaAF {

    public CocinaIndurama(String id, String articulo, int cantidadVentas, float montoTotalVentas) {
        super(id, articulo, cantidadVentas, montoTotalVentas);
    }

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