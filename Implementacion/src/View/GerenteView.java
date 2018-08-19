package View;
import Controller.PrivilegiosController;
import Model.*;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */
public class GerenteView {
    public iGerente Model;
    public VBox Pane;
    public Stage primaryStage;
    /**
     * Default constructor
     */
    
    public VBox getPane() {
        return Pane;
    }
    
    public GerenteView(Stage primaryStage) {
        this.primaryStage=primaryStage;
        Pane=new VBox();
        organize();
    }
    public void organize(){
        Label lb=new Label("Menu Gerente");
        lb.setAlignment(Pos.TOP_CENTER);
        lb.setUnderline(true);
        
        Label productos=new Label("Productos");
        productos.setAlignment(Pos.CENTER);
        Button verp=new Button("Ver");
        verp.setAlignment(Pos.CENTER);
        verp.setOnAction(e->(new PrivilegiosController()).verProducto(e, primaryStage));
        VBox vbproductos=new VBox();
        vbproductos.getChildren().addAll(productos,verp);
        vbproductos.setAlignment(Pos.CENTER);
        vbproductos.setSpacing(10);
        
        Label reporte=new Label("Reportes");
        reporte.setAlignment(Pos.CENTER);
        Button reportev=new Button("Ver");
        reportev.setAlignment(Pos.CENTER);
        reportev.setOnAction(e->(new PrivilegiosController()).verReportes(e,primaryStage));
        VBox vbreporte=new VBox();
        vbreporte.getChildren().addAll(reporte,reportev);
        vbreporte.setAlignment(Pos.CENTER);
        vbreporte.setSpacing(10);
        
        Pane.getChildren().addAll(lb,vbproductos,vbreporte);
        Pane.setAlignment(Pos.CENTER);
        Pane.setSpacing(10);
    }
    
    
    
    /**
     * @param model
     */
    public void GerenteView(iGerente model) {
        // TODO implement here
    }

}