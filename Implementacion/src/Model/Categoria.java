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
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nombre.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection m_Connection;
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDatabase", "userid", "password");
            String query = "SELECT * FROM MyTable";
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            if (m_ResultSet.next()){
                options.add(m_ResultSet.getString("Categoria"));
            }
            
        } 
        catch (SQLException ex) {
           
        }

    }

}