/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Reportes;
import javafx.collections.ObservableList;
import View.ReportesVendedorView;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controller.ReportesController;
import Model.Clientes;
import Model.Articulo;
import Model.iVendedor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.scene.Scene;

/**
 *
 * @author Fanny
 */
public class ReportesView {
    public Reportes Model;
    public VBox Pane;
    private Stage primaryStage;
    public TableView tv;
    public ComboBox cmb;
    public Button bbuscar;
    
    public VBox getPane() {
        return Pane;
    }
    
    public ReportesView(Stage primaryStage) {
        Pane=new VBox();
        Label lbreporte=new Label("Reportes");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        this.primaryStage=primaryStage;
        Pane.getChildren().addAll(lbreporte);
        organize();
    }
    
    public void organize(){
        Reportes rep = null;
        ObservableList<String> options = null;
        options.add("Reportes por Ventas Vendedor");
        options.add("Reportes por Artículos");
        options.add("Reportes por Clientes");
        rep.setOptions(options);
        ObservableList<String> opt=rep.getOptions();
        cmb=new ComboBox<>(opt);
        bbuscar=new Button("Buscar");
        bbuscar.setAlignment(Pos.CENTER);
        Pane.getChildren().addAll(cmb);
        VBox vbreportes=new VBox();
        vbreportes.getChildren().addAll(bbuscar);
        Pane.getChildren().addAll(vbreportes);
        Stage stage=new Stage();
        VBox vboton= new VBox();
        bbuscar.setOnAction((e)->{buscar(e,stage,vboton);});
        Scene scene = new Scene(vboton, 300, 300);
        stage.setTitle("Reportes");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public void buscar(ActionEvent e, Stage primarystage, VBox vboton){
        String tipoBusqueda=(String)this.cmb.getSelectionModel().getSelectedItem();
        tv.setEditable(true);
        if("Reportes por Ventas Vendedor".equals(tipoBusqueda)){
            ReportesVendedorView rv=new ReportesVendedorView(primarystage);
            rv.reportesVendedorView(vboton, tv);
        }
        else if("Reportes por Artículos".equals(tipoBusqueda)){
            ReportesArticuloView ra=new ReportesArticuloView(primarystage);
            ra.reportesArticuloView(vboton, tv);
        }
        else if("Reportes por Clientes".equals(tipoBusqueda)){
            ReportesClienteView rc=new ReportesClienteView(primarystage);
            rc.reportesClientesView(vboton, tv);
        }
    }
    
}