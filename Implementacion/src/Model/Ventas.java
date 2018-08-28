package Model;
import java.util.*;

/**
 * 
 */
public class Ventas {
    private String articulo;
    private int cantidadVentas;
    private Float Precio;

    public Ventas(String articulo,int cantidadVentas, Float Precio) {
        this.articulo=articulo;
        this.cantidadVentas = cantidadVentas;
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

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }
    
    
    

}