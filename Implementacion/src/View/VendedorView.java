package View;
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
        Label lb=new Label("Menu Administrador");
        //lb.setAlignment(Pos.CENTER);
        lb.setAlignment(Pos.TOP_CENTER);
        lb.setUnderline(true);
        Label productos=new Label("Productos");
        productos.setAlignment(Pos.CENTER);
        Button verp=new Button("Ver");
        verp.setAlignment(Pos.CENTER);
        Button actualizarp=new Button("Actualizar");
        actualizarp.setAlignment(Pos.CENTER);
        VBox vbproductos=new VBox();
        vbproductos.getChildren().addAll(productos,verp,actualizarp);
        Label ventas=new Label("Ventas");
        ventas.setAlignment(Pos.CENTER);
        Button ingresarv=new Button("Crear");
        ingresarv.setAlignment(Pos.CENTER);
        Button verv=new Button("Ver");
        verv.setAlignment(Pos.CENTER);
        Button actualizarv=new Button("Actualizar");
        actualizarv.setAlignment(Pos.CENTER);
        Button borrarv=new Button("Eliminar");
        borrarv.setAlignment(Pos.CENTER);
        VBox vbventas=new VBox();
        vbventas.getChildren().addAll(ventas,ingresarv,verv,actualizarv,borrarv);
        HBox hb=new HBox();
        hb.getChildren().addAll(vbproductos, vbventas);
        Pane.getChildren().addAll(lb,hb);
    
    }


    /**
     * @param model
     */
    public void VendedorView(Vendedor model) {
        // TODO implement here
    }

}