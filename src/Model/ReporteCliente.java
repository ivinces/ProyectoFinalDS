package Model;
import java.util.*;

/**
 * 
 */
public class ReporteCliente extends Reportes {
    public String nombres;
    public String direccion;
    public String telefono;
    public float montoPromedio;
    /**
     * Default constructor
     */
    public ReporteCliente() {
        this.nombres="";
        this.direccion="";
        this.telefono="";
        this.montoPromedio=0;
    }
    

    /**
     * @param String 
     * @param String 
     * @param String 
     * @param float
     */
    public void ReporteCliente(String nombres, String direccion, String telefono, float montoPromedio){
        this.nombres=nombres;
        this.direccion=direccion;
        this.telefono=telefono;
        this.montoPromedio=montoPromedio;
    }

    /**
     * @return
     */
    public void setNombres(String nombres) {
        this.nombres=nombres;
    }

    /**
     * @return
     */
    public String getNombres() {
        return this.nombres;
    }

    /**
     * @return
     */
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    /**
     * @return
     */
    public String getDireccion(){
        return this.direccion;
    }

    /**
     * @return
     */
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    /**
     * @return
     */
    public String getTelefono(){
        return this.telefono;
    }

    /**
     * @return
     */
    public void setMontoPromedio(float montoPromedio) {
        this.montoPromedio=montoPromedio;
    }

    /**
     * @return
     */
    public float getMontoPromedio() {
        return this.montoPromedio;
    }

}