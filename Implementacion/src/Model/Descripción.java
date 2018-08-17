package Model;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 */
public class Descripción implements Busqueda {
    ObservableList<String> options;
    /**
     * Default constructor
     */
    public Descripción() {
        options =FXCollections.observableArrayList();
    }

    public ObservableList<String> getOptions() {
        return options;
    }

    public void setOptions(ObservableList<String> options) {
        this.options = options;
    }

 
    @Override
    public void Buscar() {

    }

}