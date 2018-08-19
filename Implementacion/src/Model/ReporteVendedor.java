package Model;
import java.util.*;
import javafx.collections.ObservableList;

/**
 * 
 */
public class ReporteVendedor extends Reportes {
    public ArrayList<iVendedor> lvendedores=new ArrayList<>();
    public ReporteVendedor() {
        
    }
    
    
    @Override
    public ObservableList<String> getOptions() {
        ObservableList<String> olVend = null;
        for(iVendedor vend:this.lvendedores){
            olVend.add(vend.getNombre()+""+vend.getApellido());
        }
        return olVend;
    }

}