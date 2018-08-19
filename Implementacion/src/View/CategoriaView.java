/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CategoriaController;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author isabe
 */
public class CategoriaView {
    public VBox Pane;
    public Stage primaryStage;
    public Label label;
    ObservableList<String> options;
    ComboBox cbcategoria;
    /**
     * Default constructor
     */
    public VBox getPane() {
        return Pane;
    }
    
    public CategoriaView(Stage primaryStage,ObservableList<String> options) {
        Pane = new VBox();
        label=new Label("Busqueda Por Categoría");
        label.setAlignment(Pos.CENTER);
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
        this.options=options;
        cbcategoria=new ComboBox(options);
        organize();
    }
    
    public void organize(){
        Pane.getChildren().add(cbcategoria);
        Button buscar=new Button("Buscar");
        buscar.setAlignment(Pos.CENTER);
        buscar.setOnAction(e-> (new CategoriaController()).buscar(e,Pane,primaryStage,cbcategoria));
        Pane.getChildren().add(buscar);
        Pane.setAlignment(Pos.TOP_CENTER);
        Pane.setSpacing(10);
    
    }
}
