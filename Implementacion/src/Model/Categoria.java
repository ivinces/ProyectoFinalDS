package Model;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 */
public class Categoria implements Busqueda {
    ObservableList<String> options;
    /**
     * Default constructor
     */
    public Categoria() {
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
        // Query donde se agrega en options

    }

}