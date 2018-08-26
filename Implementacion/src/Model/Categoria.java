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
public class Categoria extends BusquedaArticulo {
    @Override
    public void Buscar() {
        Conexion c= new Conexion();
        c.conectar("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=ProyectoDS");
        String query = "SELECT DISTINCT Marca FROM Articulo,Cocina,Lavadora,Refrigeradora"
                    + "WHERE Articulo.IDArticulos=Cocina.IDArticulos AND Articulo.IDArticulos=Lavadora.IDArticulos "
                    + "AND WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
        ResultSet m_ResultSet=c.obtenerSet(query);
        if (m_ResultSet.next()){
                options.add(m_ResultSet.getString("Categoria"));
        }
    }

    @Override
    public ObservableList<String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(ObservableList<String> options) {
        this.options=options;
    }
    
    

}