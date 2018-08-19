package Model;
import java.util.*;
import javafx.collections.ObservableList;

/**
 * 
 */
public class ReporteCliente extends Reportes {
    
    public ArrayList<Clientes> lClientes=new ArrayList<>();
    /**
     * Default constructor
     */
    public ReporteCliente() {
        
    }
    
    @Override
    public ObservableList<String> getOptions() {
        ObservableList<String> olCli = null;
        for(Clientes cliente:lClientes){
            olCli.add(cliente.nombres+" "+cliente.apellidos);
        }
        return olCli;
    }

}