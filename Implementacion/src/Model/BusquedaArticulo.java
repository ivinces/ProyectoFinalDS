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
    Conexion c;
    ResultSet m_ResultSet;
    /**
     * Default constructor
     */
    public BusquedaArticulo() {
        options =FXCollections.observableArrayList();
        c=new Conexion();
    }
    
    public void obtenerSet(String query){
        PreparedStatement pstmt;
        try {
            pstmt = c.getM_Connection().prepareStatement(query);
            m_ResultSet = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public abstract void llenarSet();
    
    
    public abstract ObservableList<String> getOptions();
    public abstract void setOptions(ObservableList<String> options);
       
        
    @Override
    public abstract void Buscar();

}