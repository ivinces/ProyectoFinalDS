package Model;
import java.util.*;

/**
 * 
 */
public class ReporteVendedor extends Reportes {
    public LineaBlanca articulo;
    public int cantidad;
    public float ventasTotalesUSD;
    /**
     * Default constructor
     */
    public ReporteVendedor() {
        this.articulo= new LineaBlanca() {};
        this.cantidad=0;
        this.ventasTotalesUSD=0;
    }
    

    /**
     * @param LineaBlanca 
     * @param int 
     * @param float
     */
    public void ReporteVendedor(LineaBlanca articulo, int cantidad, float ventasTotalesUSD){
        this.articulo=articulo;
        this.cantidad=cantidad;
        this.ventasTotalesUSD=ventasTotalesUSD;
    }

    /**
     * @return
     */
    public void setArticulo(LineaBlanca articulo) {
        this.articulo=articulo;
    }

    /**
     * @return
     */
    public LineaBlanca getArticulo() {
        return this.articulo;
    }

    /**
     * @return
     */
    public void setCantidad(int cantidad) {
        this.cantidad=cantidad;
    }

    /**
     * @return
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * @return
     */
    public void setVentasTotalesUSD(float ventasTotalesUSD) {
        this.ventasTotalesUSD=ventasTotalesUSD;
    }

    /**
     * @return
     */
    public float getVentasTotalesUSD() {
        return this.ventasTotalesUSD;
    }

}