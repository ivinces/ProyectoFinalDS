/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.BusquedaController;
import Model.*;
import java.util.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Fanny
 */
public class BusquedaView {
    public Busqueda Model;
    public VBox Pane;
    public Stage primaryStage;
    public Label label;
    /**
     * Default constructor
     */
    public VBox getPane() {
        return Pane;
    }
    
    public BusquedaView(Stage primaryStage) {
        Pane = new VBox();
        label=new Label("Busqueda");
        label.setAlignment(Pos.CENTER);
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
        organize();
    }
    
    public void organize(){
        
        Button bnombre=new Button("Buscar por nombre");
        bnombre.setAlignment(Pos.CENTER);
        bnombre.setOnAction(e->(new BusquedaController()).bnombre(e, primaryStage));
        Button bdescripcion=new Button("Buscar por descripción");
        bdescripcion.setAlignment(Pos.CENTER);
        bdescripcion.setOnAction(e->{
            (new BusquedaController()).bdescripcion(e, primaryStage);
        });
        Button bcategoria=new Button("Buscar por categoria");
        bcategoria.setAlignment(Pos.CENTER);
        bcategoria.setOnAction(e->(new BusquedaController()).bcategoria(e, primaryStage));
        Pane.getChildren().addAll(bnombre,bdescripcion,bcategoria);
        Pane.setAlignment(Pos.CENTER);
        Pane.setSpacing(10);
    }
}
