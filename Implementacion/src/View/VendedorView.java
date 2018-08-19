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
public class VendedorView {
    public Vendedor Model;
    public VBox Pane;
    private Stage primaryStage;
    /**
     * Default constructor
     */
    
    public VBox getPane() {
        return Pane;
    }
    
    public VendedorView(Stage primaryStage) {
        this.primaryStage=primaryStage;
        Pane=new VBox();
        organize();
    }
    public void organize(){
        Label lb=new Label("Menu Vendedor");
        lb.setAlignment(Pos.TOP_CENTER);
        lb.setUnderline(true);
        
        Label productos=new Label("Productos");
        productos.setAlignment(Pos.CENTER);
        Button verp=new Button("Ver");
        verp.setAlignment(Pos.CENTER);
        verp.setOnAction(e->(new PrivilegiosController()).verProducto(e, primaryStage));
        Button actualizarp=new Button("Actualizar");
        actualizarp.setAlignment(Pos.CENTER);
        actualizarp.setOnAction(e->(new PrivilegiosController()).actualizarProducto(e));
        VBox vbproductos=new VBox();
        vbproductos.getChildren().addAll(productos,verp,actualizarp);
        vbproductos.setAlignment(Pos.CENTER);
        vbproductos.setSpacing(10);
        
        Label ventas=new Label("Ventas");
        ventas.setAlignment(Pos.CENTER);
        Button ingresarv=new Button("Crear");
        ingresarv.setAlignment(Pos.CENTER);
        ingresarv.setOnAction(e->(new PrivilegiosController()).crearVentas(e, primaryStage));
        VBox vbventas=new VBox();
        vbventas.getChildren().addAll(ventas,ingresarv);
        vbventas.setAlignment(Pos.CENTER);
        vbventas.setSpacing(10);
        
        Label cliente=new Label("Cliente");
        cliente.setAlignment(Pos.CENTER);
        Button verc=new Button("Ver");
        verc.setAlignment(Pos.CENTER);
        verc.setOnAction(e->(new PrivilegiosController()).verClientes(e));
        Button actualizarc=new Button("Actualizar");
        actualizarc.setAlignment(Pos.CENTER);
        actualizarc.setOnAction(e->(new PrivilegiosController()).actualizarClientes(e));
        Button crearc=new Button("Crear");
        crearc.setAlignment(Pos.CENTER);
        crearc.setOnAction(e->(new PrivilegiosController()).crearClientes(e));
        VBox vbcliente=new VBox();
        vbcliente.getChildren().addAll(cliente,verc,actualizarc,crearc);
        vbcliente.setAlignment(Pos.CENTER);
        vbcliente.setSpacing(10);
        
        Label cotizaciones=new Label("Cotizaciones");
        cotizaciones.setAlignment(Pos.CENTER);
        Button cotizacionesc=new Button("Crear");
        cotizacionesc.setAlignment(Pos.CENTER);
        cotizacionesc.setOnAction(e->(new PrivilegiosController()).crearCotizacion(e, primaryStage));
        VBox vbcotizacion=new VBox();
        vbcotizacion.getChildren().addAll(cotizaciones,cotizacionesc);
        vbcotizacion.setAlignment(Pos.CENTER);
        vbcotizacion.setSpacing(10);
        
        HBox hb=new HBox();
        hb.getChildren().addAll(vbproductos, vbventas);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(50);
        
        HBox hb2=new HBox();
        hb2.getChildren().addAll(vbcliente,vbcotizacion);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(30);
        
        Pane.getChildren().addAll(lb,hb,hb2);
        Pane.setAlignment(Pos.CENTER);
        Pane.setSpacing(10);
    
    }


    /**
     * @param model
     */
    public void VendedorView(Vendedor model) {
        // TODO implement here
    }

}