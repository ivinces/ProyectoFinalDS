/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
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
        Button bdescripcion=new Button("Buscar por descripción");
        bdescripcion.setAlignment(Pos.CENTER);
        Button bcategoria=new Button("Buscar por categoria");
        bcategoria.setAlignment(Pos.CENTER);
        Pane.getChildren().addAll(bnombre,bdescripcion,bcategoria);
    }

    private void bnombre(ActionEvent e){
        Nombre n=new Nombre();
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        ComboBox cbnombre=new ComboBox(options);
    }
    
    private void bdescripcion(ActionEvent e){
        Descripción n=new Descripción();
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        ComboBox cbdescripcion=new ComboBox(options);
    }
    
    private void bcategoria(ActionEvent e){
        Categoria n=new Categoria();
        n.Buscar();
        ObservableList<String> options=n.getOptions();
        ComboBox cbcategoria=new ComboBox(options);
    }
}
