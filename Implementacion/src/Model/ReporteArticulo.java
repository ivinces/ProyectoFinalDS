package Model;
import java.util.*;
import javafx.collections.ObservableList;

/**
 * 
 */
public class ReporteArticulo extends Reportes {
    
    public ArrayList<LineaBlancaAF> lArticulos=new ArrayList<>();
    /**
     * Default constructor
     */
    public ReporteArticulo() {
        
    }

    @Override
    public ObservableList<String> getOptions() {
        ObservableList<String> olVend = null;
        for(LineaBlancaAF art:this.lArticulos){
            olVend.add(art.articulo);
        }
        return olVend;
    }
    
}