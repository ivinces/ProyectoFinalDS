package Model;

/**
 * 
 */
public abstract class Articulo {
    public String id;
    public String color;
    public String nombre;
    public String marca;
    
    public Articulo(String id, String nombre, String marca, String color) {
        this.id = id;
        this.nombre = nombre;
        this.marca=marca;
        this.color=color;
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

    public void setDescripcion(String descripcion) {
        this.color = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    
    
    
    
}