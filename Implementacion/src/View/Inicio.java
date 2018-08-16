package View;
import Model.*;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */
public class Inicio {
    public iUsuarios Model;
    public HBox Pane;
    private Label label; 
    private Stage primaryStage;
    /**
     * Default constructor
     */
    public HBox getPane() {
        return Pane;
    }
    
    public Inicio(Stage primaryStage) {
        Pane = new HBox();
        label=new Label("Bienvenido");
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
        organize();
    }
    
    public void organize(){
        Label lb=new Label("Ingresa tu usario");
        TextArea txarea=new TextArea();
        Label lb2=new Label("Ingresa tu clave");
        TextArea txarea2=new TextArea();
        Button ingresar=new Button("Ingresar");
        Pane.getChildren().addAll(lb,txarea,lb2,txarea2, ingresar);
    
    }
    
    
    private void ingresar(ActionEvent e){
        Stage stage = new Stage();
        Scene scene;
        if(true){
            AdministradorView c = new AdministradorView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        else if(false){
            GerenteView c = new GerenteView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        
        else if(true){
            SuperAdministradorView c = new SuperAdministradorView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        else{
            VendedorView c = new VendedorView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        
        stage.setTitle("");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    
    }
            
    public void Inicio(iUsuarios model) {
        // TODO implement here
    }

}