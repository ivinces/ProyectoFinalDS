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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
    
    public void reportesArticuloView(VBox vboton,TableView tv,VBox Pane) throws SQLException{
        ArrayList<Articulo> list= new ReportesController().BuscaArticulos();
        ArrayList<Ventas> list2= new ReportesController().BuscaVentas();
        tv = new TableView(generateDataInMapArticulos(list,list2));
        
        Label lbreporte=new Label("Reportes Articulos");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id  = new TableColumn<>("Id");
        TableColumn<Map, String> cantidad  = new TableColumn<>("Cantidad");
        TableColumn<Map, String> articulo  = new TableColumn<>("Articulo");
        TableColumn<Map, String> ventaTotalUSD = new TableColumn<>("Ventas Totales en Dolares");
        
        id.setCellValueFactory(new MapValueFactory("Id"));
        id.setMinWidth(100);
        cantidad.setCellValueFactory(new MapValueFactory("Cantidad"));
        cantidad.setMinWidth(100);
        articulo.setCellValueFactory(new MapValueFactory("Articulo"));
        articulo.setMinWidth(100);
        ventaTotalUSD.setCellValueFactory(new MapValueFactory("Ventas Totales en Dolares"));
        ventaTotalUSD.setMinWidth(100);
        
        tv.getColumns().addAll(id, cantidad, articulo, ventaTotalUSD);
        
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
            cellFactoryForMap = (TableColumn<Map, String> p) -> 
                new TextFieldTableCell(new StringConverter() {
                    @Override
                        public String toString(Object t) {
                        return t.toString();
                    }
                    @Override
                    public Object fromString(String string) {
                        return string;
                    }
            });
        id.setCellFactory(cellFactoryForMap);
        cantidad.setCellFactory(cellFactoryForMap);
        articulo.setCellFactory(cellFactoryForMap);
        ventaTotalUSD.setCellFactory(cellFactoryForMap);
        
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
                System.out.println(cantidad+"<<<<<<<<");
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
