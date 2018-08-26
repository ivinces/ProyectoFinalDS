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
import javafx.stage.Stage;
/**
 * 
 */
public class BusquedaController {

    public BusquedaController() {
    }
    
    public void bnombre(ActionEvent e,Stage primaryStage){
        BusquedaArticulo n=new Nombre();
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        NombreView busview=new NombreView(primaryStage,options);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(busview.getPane(), 500, 500);
        stage.setTitle("Busqueda por Nombre");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
        
    }
    
    public void bdescripcion(ActionEvent e,Stage primaryStage){
        BusquedaArticulo n=new Descripción();
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        DescripcionView s=new DescripcionView(primaryStage,options);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(s.getPane(), 500, 500);
        stage.setTitle("Busqueda por Descripcion");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }
    
    public void bcategoria(ActionEvent e,Stage primaryStage){
        BusquedaArticulo n=new Categoria();
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        CategoriaView bus=new CategoriaView(primaryStage,options);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(bus.getPane(), 500, 500);
        stage.setTitle("Busqueda por Categoria");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }

}