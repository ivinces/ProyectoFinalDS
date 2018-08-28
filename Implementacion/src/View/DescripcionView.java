/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DescripcionController;
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
public class DescripcionView {
    public VBox Pane;
    public Stage primaryStage;
    public Label label;
    ObservableList<String> options;
    ComboBox cbdescripcion;
    /**
     * Default constructor
     */
    public VBox getPane() {
        return Pane;
    }
    
    public DescripcionView(Stage primaryStage,ObservableList<String> options) {
        Pane = new VBox();
        label=new Label("Busqueda Por Descripción");
        label.setAlignment(Pos.CENTER);
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
        this.options=options;
        cbdescripcion=new ComboBox(options);
        Pane.getChildren().add(cbdescripcion);
        organize();
    }
    
    public void organize(){
        Button buscar=new Button("Buscar");
        buscar.setAlignment(Pos.CENTER);
        buscar.setOnAction(e-> (new DescripcionController()).buscar(e,Pane,primaryStage,cbdescripcion));
        Pane.getChildren().add(buscar);
        Pane.setAlignment(Pos.TOP_CENTER);
        Pane.setSpacing(10);
    }
}
