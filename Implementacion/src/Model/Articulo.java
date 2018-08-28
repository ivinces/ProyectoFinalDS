package Model;

/**
 * 
 */
public abstract class Articulo {
    private String id;
    private String color;
    private String nombre;
    private String marca;
    private String modelo;
    private float precio;

    public Articulo(String id, String color, String nombre, String marca, float precio, String modelo) {
        this.id = id;
        this.color = color;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.modelo=modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Articulo() {
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    
    
    
    
}