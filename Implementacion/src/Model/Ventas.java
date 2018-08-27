package Model;
import java.util.*;

/**
 * 
 */
public class Ventas {
    private int cantidadVentas;
    private String id;
    private Date Fecha;
    private Float Precio;

    public Ventas(int cantidadVentas, String id, Date Fecha, Float Precio) {
        this.cantidadVentas = cantidadVentas;
        this.id = id;
        this.Fecha = Fecha;
        this.Precio = Precio;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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