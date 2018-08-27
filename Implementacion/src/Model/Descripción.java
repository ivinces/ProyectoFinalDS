package Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        c.conectar();
        String query = "SELECT DISTINCT Marca FROM Articulo,Cocina,Lavadora,Refrigeradora"
                    + "WHERE Articulo.IDArticulos=Cocina.IDArticulos AND Articulo.IDArticulos=Lavadora.IDArticulos "
                    + "AND WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
        ResultSet rs= c.obtenerSet(query);
        llenarSet(rs);
    }

    @Override
    public void llenarSet(ResultSet rs) {
        try {
            while(rs.next()){
                options.add(rs.getString("Descripción"));
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
