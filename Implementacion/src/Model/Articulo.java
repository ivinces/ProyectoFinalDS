package Model;
import java.util.*;

/**
 * 
 */
public abstract class Articulo {
    public String id;
    public String articulo;
    public int cantidadVentas;
    public float montoTotalVentas;
    public String descripcion;
    public String nombre;
    public String marca;
    
    public Articulo(String id, String articulo, int cantidadVentas, float montoTotalVentas) {
        this.id = id;
        this.articulo = articulo;
        this.cantidadVentas = cantidadVentas;
        this.montoTotalVentas = montoTotalVentas;
    }
    
    public Articulo() {
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

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    
    
    
    
}