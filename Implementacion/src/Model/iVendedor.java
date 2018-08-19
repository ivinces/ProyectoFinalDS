/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Fanny
 */
public class iVendedor {
    private String id;
    private String nombre;
    private String apellido;
    private int cantidadVentas;
    private float ventasTotalesUSD;
    private boolean ocupado;
    private iVendedor next;
    
    public iVendedor(){
        this.next=new iVendedor();
    }

    public iVendedor(String id, String nombre, String apellido, int cantidadVentas, float ventasTotalesUSD, boolean ocupado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantidadVentas = cantidadVentas;
        this.ventasTotalesUSD = ventasTotalesUSD;
        this.ocupado = ocupado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public float getVentasTotalesUSD() {
        return ventasTotalesUSD;
    }

    public void setVentasTotalesUSD(float ventasTotalesUSD) {
        this.ventasTotalesUSD = ventasTotalesUSD;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
    
}
