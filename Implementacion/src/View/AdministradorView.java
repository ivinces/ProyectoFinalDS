package View;
import Controller.PrivilegiosController;
import Controller.Productos_Privilegios_Controller;
import Controller.Repor_Privilegios_Controller;
import Controller.Ventas_Privilegios_Controller;
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
        
        VBox vbproductos=productos_ad();
        VBox vbventas=ventas_ad();
        VBox vbreporte=reportes_ad();
        HBox hb=new HBox();
        hb.getChildren().addAll(vbproductos, vbventas);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(30);
        Pane.getChildren().addAll(lb,hb,vbreporte);
        Pane.setAlignment(Pos.CENTER);
        Pane.setSpacing(10);
    
    }
    
    public VBox productos_ad(){
        Label productos=new Label("Productos");
        productos.setAlignment(Pos.CENTER);
        Button ingresarp=new Button("Crear");
        ingresarp.setAlignment(Pos.CENTER);
        ingresarp.setOnAction(e->(new Productos_Privilegios_Controller()).crearProducto(e));
        Button verp=new Button("Ver");
        verp.setAlignment(Pos.CENTER);
        verp.setOnAction(e->(new Productos_Privilegios_Controller()).verProducto(e, primaryStage));
        Button actualizarp=new Button("Actualizar");
        actualizarp.setAlignment(Pos.CENTER);
        actualizarp.setOnAction(e->(new Productos_Privilegios_Controller()).actualizarProducto(e));
        Button borrarp=new Button("Eliminar");
        borrarp.setAlignment(Pos.CENTER);
        borrarp.setOnAction(e->(new Productos_Privilegios_Controller()).eliminarProducto(e));
        
        VBox vbproductos=new VBox();
        vbproductos.getChildren().addAll(productos,ingresarp,verp,actualizarp,borrarp);
        vbproductos.setAlignment(Pos.CENTER);
        vbproductos.setSpacing(10);
    
        return vbproductos;
    }
    
    public VBox reportes_ad(){
    
        Label reporte=new Label("Reportes");
        reporte.setAlignment(Pos.CENTER);
        Button reportev=new Button("Ver");
        reportev.setAlignment(Pos.CENTER);
        reportev.setOnAction(e->(new Repor_Privilegios_Controller()).verReportes(e,primaryStage));
        VBox vbreporte=new VBox();
        vbreporte.getChildren().addAll(reporte,reportev);
        vbreporte.setAlignment(Pos.CENTER);
        vbreporte.setSpacing(10);
        
        return vbreporte;
    } 
    
    public VBox ventas_ad(){
        
        Label ventas=new Label("Ventas");
        ventas.setAlignment(Pos.CENTER);
        Button ingresarv=new Button("Crear");
        ingresarv.setAlignment(Pos.CENTER);
        ingresarv.setOnAction(e->(new Ventas_Privilegios_Controller()).crearVentas(e, primaryStage));
        Button actualizarv=new Button("Actualizar");
        actualizarv.setAlignment(Pos.CENTER);
        actualizarv.setOnAction(e->(new Ventas_Privilegios_Controller()).actualizarVentas(e));
        Button borrarv=new Button("Eliminar");
        borrarv.setAlignment(Pos.CENTER);
        borrarv.setOnAction(e->(new Ventas_Privilegios_Controller()).eliminarVentas(e));
        VBox vbventas=new VBox();
        vbventas.getChildren().addAll(ventas,ingresarv,actualizarv,borrarv);
        vbventas.setAlignment(Pos.CENTER);
        vbventas.setSpacing(10);
        
        return vbventas;  
    }
}