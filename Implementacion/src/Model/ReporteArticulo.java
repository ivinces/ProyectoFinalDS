package Model;
import java.util.*;

/**
 * 
 */
public class ReporteArticulo extends Reportes {
    public iVendedor vendedor;
    public int cantidadVentas;
    public float montoTotalVentas;
    /**
     * Default constructor
     */
    public ReporteArticulo() {
        this.vendedor=new iVendedor();
        this.cantidadVentas=0;
        this.montoTotalVentas=0;
    }

    /**
     * @param Vendedor 
     * @param int 
     * @param float
     */
    public void ReporteArticulo(iVendedor vendedor, int cantidadVentas, float montoTotalVentas) {
        this.vendedor=vendedor;
        this.cantidadVentas=cantidadVentas;
        this.montoTotalVentas=montoTotalVentas;
    }

    /**
     * @return
     */
    public void setVendedor(iVendedor vendedor) {
        this.vendedor=vendedor;
    }

    /**
     * @return
     */
    public iVendedor getVendedor() {
        return this.vendedor;
    }

    /**
     * @return
     */
    public void setCantidad(int cantidadVentas) {
        this.cantidadVentas=cantidadVentas;
    }

    /**
     * @return
     */
    public int getCantidad() {
        return this.cantidadVentas;
    }

    /**
     * @return
     */
    public void setMontoTotalVentas(float montoTotalVentas) {
        this.montoTotalVentas=montoTotalVentas;
    }

    /**
     * @return
     */
    public float getMontoTotalVentas() {
        return this.montoTotalVentas;
    }

}