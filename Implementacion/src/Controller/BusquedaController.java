package Controller;
import Model.BusquedaArticulo;
import Model.Categoria;
import Model.Descripción;
import Model.Nombre;
import View.CategoriaView;
import View.DescripcionView;
import View.NombreView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * 
 */
public class BusquedaController {

    public BusquedaController() {
    }
    
    public void bnombre(ActionEvent e,Stage primaryStage){
        BusquedaArticulo n=new Nombre();
        ObservableList<String> op=opcionesBusqueda(n);
        NombreView busview=new NombreView(primaryStage,op);
        organizeStage(busview.getPane(),primaryStage,"Búsqueda por Categoría");
        
    }
    
    public void bdescripcion(ActionEvent e,Stage primaryStage){
        BusquedaArticulo n=new Descripción();
        ObservableList<String> op=opcionesBusqueda(n);
        DescripcionView s=new DescripcionView(primaryStage,op);
        organizeStage(s.getPane(),primaryStage,"Búsqueda por Categoría");
    }
    
    public void bcategoria(ActionEvent e,Stage primaryStage){
        BusquedaArticulo n=new Categoria();
        ObservableList<String> op=opcionesBusqueda(n);
        CategoriaView bus=new CategoriaView(primaryStage,op);
        organizeStage(bus.getPane(),primaryStage,"Búsqueda por Categoría");
    }
    
    public ObservableList<String> opcionesBusqueda(BusquedaArticulo n){
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        return options;
    }
    
    public void organizeStage(VBox pane,Stage primaryStage,String title){
        Stage stage=new Stage();
        Scene scene= new Scene(pane,500,500);
        stage.setTitle(title);
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }

}