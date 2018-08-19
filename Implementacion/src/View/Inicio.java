package View;
import Controller.InicioController;
import Model.*;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */
public class Inicio {
    public iUsuarios Model;
    public VBox Pane;
    private Label label; 
    private Stage primaryStage;
    /**
     * Default constructor
     */
    public VBox getPane() {
        return Pane;
    }
    
    public Inicio(Stage primaryStage) {
        Pane = new VBox();
        label=new Label("Bienvenido");
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
        organize();
    }
    
    public void organize(){
        Label lb=new Label("Ingresa tu usario");
        TextField txarea=new TextField();
        Label lb2=new Label("Ingresa tu clave");
        TextField txarea2=new TextField();
        Button ingresar=new Button("Ingresar");
        ingresar.setOnAction(e->(new InicioController()).ingresar(e, primaryStage,
                txarea.getText(),txarea2.getText()));
        Pane.getChildren().addAll(lb,txarea,lb2,txarea2, ingresar);
    
    }
}