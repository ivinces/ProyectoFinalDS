
import java.util.*;

/**
 * 
 */
public interface iVendedor {

    /**
     * @return
     */
    public void nuevoCliente();

    /**
     * @param iVendedor 
     * @return
     */
    public void setNext(void iVendedor);

    /**
     * @return
     */
    public iVendedor getNext();

}