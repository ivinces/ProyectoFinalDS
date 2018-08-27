package Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 */
public abstract class BusquedaArticulo implements Busqueda {

    ObservableList<String> options;
    ProcesosDB c;
    /**
     * Default constructor
     */
    public BusquedaArticulo() {
        options =FXCollections.observableArrayList();
        c=new ProcesosDB();
    }
    
    public abstract void llenarSet(ResultSet rs);
    
    
    public abstract ObservableList<String> getOptions();
    public abstract void setOptions(ObservableList<String> options);
       
        
    @Override
    public abstract void Buscar();

}