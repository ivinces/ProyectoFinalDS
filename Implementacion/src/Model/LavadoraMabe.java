package Model;
import java.util.*;

/**
 * 
 */
public class LavadoraMabe extends LineaBlancaAF {

    public LavadoraMabe(String id, String articulo, int cantidadVentas, float montoTotalVentas) {
        super(id, articulo, cantidadVentas, montoTotalVentas);
    }

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
