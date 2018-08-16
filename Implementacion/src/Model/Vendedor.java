package Model;
import java.util.*;

/**
 * 
 */
public interface Vendedor {

    /**
     * @return
     */
    public void nuevoCliente();

    /**
     * @param iVendedor 
     * @return
     */
    public void setNext(Vendedor vendedor);

    /**
     * @return
     */
    public Vendedor getNext();

}