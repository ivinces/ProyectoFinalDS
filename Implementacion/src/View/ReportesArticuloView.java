/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportesController;
import Model.Articulo;
import Model.Clientes;
import Model.Ventas;
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
        ArrayList<Ventas> list2= new ReportesController().BuscaVentas();
        tv = new TableView(generateDataInMapArticulos(list,list2));
        vboton.getChildren().addAll(lbreporte,tv);
        Pane.getChildren().add(vboton);
    }
    
    private ObservableList generateDataInMapArticulos(ArrayList<Articulo> list, ArrayList<Ventas> list2) {        
        ObservableList<Map> allData = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> dataRow = new HashMap<>();
                String id = list.get(i).getId();
                String cantidad="0";
                String ventaTotalUSD="0";
                for (int j = 0; j < list2.size(); j++) {
                    if(list.get(i).getNombre().equals(list2.get(j).getArticulo())){
                        cantidad = String.valueOf(list2.get(j).getCantidadVentas());
                        ventaTotalUSD = String.valueOf(list2.get(j).getPrecio());
                    }
                }
                String articulo = list.get(i).getNombre();
                dataRow.put("Id", id);
                dataRow.put("Cantidad", cantidad);
                dataRow.put("Articulo", articulo);
                dataRow.put("Ventas Totales en Dolares", ventaTotalUSD);
                allData.add(dataRow);
        }
        return allData;
    }
    
}
