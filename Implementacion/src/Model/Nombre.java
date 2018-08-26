package Model;
import javafx.collections.ObservableList;
import java.sql.*;

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
        
        try {
            Connection m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=ProyectoDS");
            String query = "SELECT DISTINCT Nombre FROM Articulo,Cocina,Lavadora,Refrigeradora"
                    + "WHERE Articulo.IDArticulos=Cocina.IDArticulos AND Articulo.IDArticulos=Lavadora.IDArticulos "
                    + "AND WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            String s= m_ResultSet.getString("Nombre");
            if (m_ResultSet.next()){
                options.add(s);
            }
                       
            
        } 
        catch (SQLException ex) {
             System.out.println("prueba de error");
            
           
        }  
    }

}