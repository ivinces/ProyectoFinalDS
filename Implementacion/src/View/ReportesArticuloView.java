/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportesController;
import Model.Articulo;
import Model.Clientes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Fanny
 */
public class ReportesArticuloView {
    
    public VBox Pane;
    public Stage primaryStage;
    public Label label;
    
    public ReportesArticuloView(Stage primaryStage) {
        Pane = new VBox();
        label=new Label("Reportes Vendedor");
        label.setAlignment(Pos.CENTER);
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
    }
    
    public void reportesArticuloView(VBox vboton,TableView tv){
        Label lbreporte=new Label("Reportes Articulos");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id  = new TableColumn<>("Id");
        TableColumn<Map, String> cantidad  = new TableColumn<>("Cantidad");
        TableColumn<Map, String> articulo  = new TableColumn<>("Articulo");
        TableColumn<Map, String> ventaTotalUSD = new TableColumn<>("Ventas Totales en Dolares");
        tv.getColumns().addAll(id, cantidad, articulo, ventaTotalUSD);
        ArrayList<Articulo> list= new ReportesController().BuscaArticulos();
        tv = new TableView(generateDataInMapArticulos(list));
        vboton.getChildren().addAll(lbreporte,tv);
    }
    
    private ObservableList generateDataInMapArticulos(ArrayList<Articulo> list) {        
        ObservableList<Map> allData = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> dataRow = new HashMap<>();
                String id = list.get(i).getId();
                String cantidad = String.valueOf(list.get(i)());
                String articulo = list.get(i).getNombre();
                String ventaTotalUSD = String.valueOf(list.get(i).getMontoTotalVentas());
                dataRow.put("Id", id);
                dataRow.put("Cantidad", cantidad);
                dataRow.put("Articulo", articulo);
                dataRow.put("Ventas Totales en Dolares", ventaTotalUSD);
                allData.add(dataRow);
        }
        return allData;
    }
    
}
