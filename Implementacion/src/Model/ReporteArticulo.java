package Model;
import java.util.*;
import javafx.collections.ObservableList;

/**
 * 
 */
public class ReporteArticulo extends Reportes {
    
    public ArrayList<Articulo> lArticulos=new ArrayList<>();
    /**
     * Default constructor
     */
    public ReporteArticulo() {
        
    }

    @Override
    public ObservableList<String> getOptions() {
        ObservableList<String> olVend = null;
        for(Articulo art:this.lArticulos){
            olVend.add(art.getNombre());
        }
        return olVend;
    }
    
}