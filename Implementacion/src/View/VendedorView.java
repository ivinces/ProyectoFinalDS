package View;
import Controller.Clientes_Privilegios_Controller;
import Controller.Cotiza_Privilegios_Controller;
import Controller.PrivilegiosController;
import Controller.Productos_Privilegios_Controller;
import Controller.Ventas_Privilegios_Controller;
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
        
        VBox vbproductos=productos_ve();
        VBox vbventas=ventas_ve();
        VBox vbcliente=cliente_ve();
        VBox vbcotizacion=cotizaciones_ve();

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

    public VBox productos_ve(){
    
        Label productos=new Label("Productos");
        productos.setAlignment(Pos.CENTER);
        Button verp=new Button("Ver");
        verp.setAlignment(Pos.CENTER);
        verp.setOnAction(e->(new Productos_Privilegios_Controller()).verProducto(e, primaryStage));
        Button actualizarp=new Button("Actualizar");
        actualizarp.setAlignment(Pos.CENTER);
        actualizarp.setOnAction(e->(new Productos_Privilegios_Controller()).actualizarProducto(e));
        VBox vbproductos=new VBox();
        vbproductos.getChildren().addAll(productos,verp,actualizarp);
        vbproductos.setAlignment(Pos.CENTER);
        vbproductos.setSpacing(10);
        
        return vbproductos;
    }
    
    public VBox cotizaciones_ve(){
        Label cotizaciones=new Label("Cotizaciones");
        cotizaciones.setAlignment(Pos.CENTER);
        Button cotizacionesc=new Button("Crear");
        cotizacionesc.setAlignment(Pos.CENTER);
        cotizacionesc.setOnAction(e->(new Cotiza_Privilegios_Controller()).crearCotizacion(e, primaryStage));
        VBox vbcotizacion=new VBox();
        vbcotizacion.getChildren().addAll(cotizaciones,cotizacionesc);
        vbcotizacion.setAlignment(Pos.CENTER);
        vbcotizacion.setSpacing(10);
        
        return vbcotizacion;
    
    }
    
    public VBox cliente_ve(){
    
        Label cliente=new Label("Cliente");
        cliente.setAlignment(Pos.CENTER);
        Button verc=new Button("Ver");
        verc.setAlignment(Pos.CENTER);
        verc.setOnAction(e->(new Clientes_Privilegios_Controller()).verClientes(e));
        Button actualizarc=new Button("Actualizar");
        actualizarc.setAlignment(Pos.CENTER);
        actualizarc.setOnAction(e->(new Clientes_Privilegios_Controller()).actualizarClientes(e));
        Button crearc=new Button("Crear");
        crearc.setAlignment(Pos.CENTER);
        crearc.setOnAction(e->(new Clientes_Privilegios_Controller()).crearClientes(e));
        VBox vbcliente=new VBox();
        vbcliente.getChildren().addAll(cliente,verc,actualizarc,crearc);
        vbcliente.setAlignment(Pos.CENTER);
        vbcliente.setSpacing(10);
        
        return vbcliente;
    
    }
    
    public VBox ventas_ve(){
    
        Label ventas=new Label("Ventas");
        ventas.setAlignment(Pos.CENTER);
        Button ingresarv=new Button("Crear");
        ingresarv.setAlignment(Pos.CENTER);
        ingresarv.setOnAction(e->(new Ventas_Privilegios_Controller()).crearVentas(e, primaryStage));
        VBox vbventas=new VBox();
        vbventas.getChildren().addAll(ventas,ingresarv);
        vbventas.setAlignment(Pos.CENTER);
        vbventas.setSpacing(10);
        
        return vbventas;
    
    }
    

    /**
     * @param model
     */
    public void VendedorView(Vendedor model) {
        // TODO implement here
    }

}