package Model;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 */
public abstract class BusquedaArticulo implements Busqueda {

    ObservableList<String> options;
    /**
     * Default constructor
     */
    public BusquedaArticulo() {
        options =FXCollections.observableArrayList();
    }
    
    public abstract ObservableList<String> getOptions();
    public abstract void setOptions(ObservableList<String> options);
    @Override
    public abstract void Buscar();

}