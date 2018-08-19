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
        
        Label ventas=new Label("Reportes");
        ventas.setAlignment(Pos.CENTER);
        Button verv=new Button("Ver");
        verv.setAlignment(Pos.CENTER);
        verv.setOnAction(e->(new PrivilegiosController()).verReportes(e));
        VBox vbventas=new VBox();
        vbventas.getChildren().addAll(ventas,verv);
        vbventas.setAlignment(Pos.CENTER);
        vbventas.setSpacing(10);
        
        Pane.getChildren().addAll(lb,vbproductos,vbventas);
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