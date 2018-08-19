package Model;
import java.util.*;

/**
 * 
 */
public abstract class LineaBlancaAF {
    public String id;
    public String articulo;
    public int cantidadVentas;
    public float montoTotalVentas;
    
    public abstract LineaBlanca CrearArticulo();

    /**
     * @return
     */
    public abstract Marca AsignarMarca();

    public LineaBlancaAF(String id, String articulo, int cantidadVentas, float montoTotalVentas) {
        this.id = id;
        this.articulo = articulo;
        this.cantidadVentas = cantidadVentas;
        this.montoTotalVentas = montoTotalVentas;
    }
    
    public LineaBlancaAF() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public float getMontoTotalVentas() {
        return montoTotalVentas;
    }

    public void setMontoTotalVentas(float montoTotalVentas) {
        this.montoTotalVentas = montoTotalVentas;
    }

    
    
    
    
}