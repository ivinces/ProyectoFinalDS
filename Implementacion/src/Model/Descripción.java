package Model;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Descripción extends BusquedaArticulo {
    /**
     * Default constructor
     */
    public Descripción() {
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
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nombre.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection m_Connection;
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=ProyectoDS", "userid", "password");
            String query = "SELECT DISTINCT Color FROM Articulo,Cocina,Lavadora,Refrigeradora"
                    + "WHERE Articulo.IDArticulos=Cocina.IDArticulos AND Articulo.IDArticulos=Lavadora.IDArticulos "
                    + "AND WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            if (m_ResultSet.next()){
                options.add(m_ResultSet.getString("Descripcion"));
            }
            
        } 
        catch (SQLException ex) {
           
        }
    }

}