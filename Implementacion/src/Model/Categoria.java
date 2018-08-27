package Model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 * 
 */
public class Categoria extends BusquedaArticulo {
    @Override
    public void Buscar() {
        c.conectar("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=ProyectoDS");
        String query = "SELECT DISTINCT Marca FROM Articulo,Cocina,Lavadora,Refrigeradora"
                    + "WHERE Articulo.IDArticulos=Cocina.IDArticulos AND Articulo.IDArticulos=Lavadora.IDArticulos "
                    + "AND WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
        obtenerSet(query);
        llenarSet();
    }

    @Override
    public ObservableList<String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(ObservableList<String> options) {
        this.options=options;
    }

    @Override
    public void llenarSet() {
        try {
            while(m_ResultSet.next()){
                options.add(m_ResultSet.getString("Categoría"));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}