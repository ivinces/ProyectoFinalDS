package Model;
import java.util.*;

/**
 * 
 */
public abstract class Marca {
    private String marca;
    /**
     * Default constructor
     */
    public abstract void colocarMarca(LineaBlanca la);

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}