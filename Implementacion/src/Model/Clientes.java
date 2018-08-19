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
public class Clientes {
    public String nombres;
    public String apellidos;
    public String id;
    public String direccion;
    public String telefono;
    public float montoPromedio;

    public Clientes(String nombres, String apellidos, String id, String direccion, String telefono, float montoPromedio) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.montoPromedio = montoPromedio;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getMontoPromedio() {
        return montoPromedio;
    }

    public void setMontoPromedio(float montoPromedio) {
        this.montoPromedio = montoPromedio;
    }
    
}
