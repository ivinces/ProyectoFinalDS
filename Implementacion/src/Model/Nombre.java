package Model;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Nombre extends BusquedaArticulo {
    /**
     * Default constructor
     */
    public Nombre() {
        
    }

    @Override
    public ObservableList<String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(ObservableList<String> options) {
        this.options = options;
    }

    
    @Override
    public void Buscar() {
            c.conectar("jdbc:sqlserver://;database=DB_Name;integratedSecurity=true;");
            String query = "SELECT DISTINCT Nombre FROM Articulo,Cocina,Lavadora,Refrigeradora"
                    + "WHERE Articulo.IDArticulos=Cocina.IDArticulos AND Articulo.IDArticulos=Lavadora.IDArticulos "
                    + "AND WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
            obtenerSet(query);
            llenarSet();
    }

    @Override
    public void llenarSet() {
        try {
            while(m_ResultSet.next()){
                options.add(m_ResultSet.getString("Nombre"));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}