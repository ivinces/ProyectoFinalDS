package View;
import Controller.PrivilegiosController;
import Model.*;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */
public class AdministradorView {
    public iAdministrador Model;
    public VBox Pane;
    private Stage primaryStage;
    /**
     * Default constructor
     * @param primaryStage
     */
    public VBox getPane() {
        return Pane;
    }
    
    public AdministradorView(Stage primaryStage) {
        this.primaryStage=primaryStage;
        Pane=new VBox();
        organize();
    }
    public void organize(){
        Label lb=new Label("Menu Administrador");
        lb.setAlignment(Pos.TOP_CENTER);
        lb.setUnderline(true);
        Label productos=new Label("Productos");
        productos.setAlignment(Pos.CENTER);
        Button ingresarp=new Button("Crear");
        ingresarp.setAlignment(Pos.CENTER);
        ingresarp.setOnAction(e->(new PrivilegiosController()).crearProducto(e));
        Button verp=new Button("Ver");
        verp.setAlignment(Pos.CENTER);
        verp.setOnAction(e->(new PrivilegiosController()).verProducto(e, primaryStage));
        Button actualizarp=new Button("Actualizar");
        actualizarp.setAlignment(Pos.CENTER);
        actualizarp.setOnAction(e->(new PrivilegiosController()).actualizarProducto(e));
        Button borrarp=new Button("Eliminar");
        borrarp.setAlignment(Pos.CENTER);
        borrarp.setOnAction(e->(new PrivilegiosController()).eliminarProducto(e));
        VBox vbproductos=new VBox();
        vbproductos.getChildren().addAll(productos,ingresarp,verp,actualizarp,borrarp);
        vbproductos.setAlignment(Pos.CENTER);
        vbproductos.setSpacing(10);
        
        
        Label ventas=new Label("Ventas");
        ventas.setAlignment(Pos.CENTER);
        Button ingresarv=new Button("Crear");
        ingresarv.setAlignment(Pos.CENTER);
        ingresarv.setOnAction(e->(new PrivilegiosController()).crearVentas(e, primaryStage));
        Button actualizarv=new Button("Actualizar");
        actualizarv.setAlignment(Pos.CENTER);
        actualizarv.setOnAction(e->(new PrivilegiosController()).actualizarVentas(e));
        Button borrarv=new Button("Eliminar");
        borrarv.setAlignment(Pos.CENTER);
        borrarv.setOnAction(e->(new PrivilegiosController()).eliminarVentas(e));
        VBox vbventas=new VBox();
        vbventas.getChildren().addAll(ventas,ingresarv,actualizarv,borrarv);
        vbventas.setAlignment(Pos.CENTER);
        vbventas.setSpacing(10);
        
        
        HBox hb=new HBox();
        hb.getChildren().addAll(vbproductos, vbventas);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(30);
        Pane.getChildren().addAll(lb,hb);
        Pane.setAlignment(Pos.CENTER);
        Pane.setSpacing(10);
    
    }
}