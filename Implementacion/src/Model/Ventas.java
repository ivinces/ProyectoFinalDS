package Model;
import java.util.*;

/**
 * 
 */
public class Ventas {
    private String articulo;
    private int cantidadVentas;
    private Date Fecha;
    private Float Precio;

    public Ventas(String articulo,int cantidadVentas, Date Fecha, Float Precio) {
        this.articulo=articulo;
        this.cantidadVentas = cantidadVentas;
        this.Fecha = Fecha;
        this.Precio = Precio;
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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }
    
    
    

}