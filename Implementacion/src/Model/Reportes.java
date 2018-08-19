package Model;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 */
public abstract class Reportes {
    ObservableList<String> options;
    /**
     * Default constructor
     */
    public Reportes() {
        options =FXCollections.observableArrayList();
        
    }

    public ObservableList<String> getOptions() {
        return options;
    }

    public void setOptions(ObservableList<String> options) {
        this.options = options;
    }
    
}