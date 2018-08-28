package Model;

/**
 * 
 */
public class Cocina extends Articulo {
    public boolean induccion;
    Articulo lb;


    public Cocina(String id, String color, String nombre, String marca, float precio, String modelo) {
        super(id, color, nombre, marca, precio, modelo);
        this.induccion=true;

    }



}