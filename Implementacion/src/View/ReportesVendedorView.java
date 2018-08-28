/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportesController;
import Model.iVendedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
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
public class ReportesVendedorView {
    
    public VBox Pane;
    public Stage primaryStage;
    public Label label;
    
    public ReportesVendedorView(Stage primaryStage) {
        Pane = new VBox();
        label=new Label("Reportes Vendedor");
        label.setAlignment(Pos.CENTER);
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
    }
    
    public void reportesVendedorView(VBox vboton,TableView tv, VBox Pane) throws SQLException{
        ArrayList<iVendedor> list= new ReportesController().BuscaVendedor();
        tv=new TableView(this.generateDataInMapVendedor(list));
        tv.setEditable(true);
        Label lbreporte=new Label("Reportes Vendores");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id = new TableColumn<>("Id");
        TableColumn<Map, String> vendedor = new TableColumn<>("Vendedor");
        TableColumn<Map, String> cantidadVentas = new TableColumn<>("Cantidad Ventas");
        TableColumn<Map, String> montoTotalVentas = new TableColumn<>("Monto Total de Ventas");
        
        id.setCellValueFactory(new MapValueFactory("Id"));
        id.setMinWidth(100);
        vendedor.setCellValueFactory(new MapValueFactory("Vendedor"));
        vendedor.setMinWidth(100);
        cantidadVentas.setCellValueFactory(new MapValueFactory("Cantidad Ventas"));
        cantidadVentas.setMinWidth(100);
        montoTotalVentas.setCellValueFactory(new MapValueFactory("Monto Total de Ventas"));
        montoTotalVentas.setMinWidth(100);
        
        tv.getColumns().addAll(id, vendedor, cantidadVentas, montoTotalVentas);
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
        vendedor.setCellFactory(cellFactoryForMap);
        cantidadVentas.setCellFactory(cellFactoryForMap);
        montoTotalVentas.setCellFactory(cellFactoryForMap);
        
        vboton.getChildren().addAll(lbreporte,tv);
        Pane.getChildren().add(vboton);
    }
    
    private ObservableList generateDataInMapVendedor(ArrayList<iVendedor> list) {        
        ObservableList<Map> allData = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> dataRow = new HashMap<>();
                String id = list.get(i).getId();
                String vendedor = list.get(i).getNombre()+" "+list.get(i).getApellido();
                String cantVentas = String.valueOf(list.get(i).getCantidadVentas());
                String montoTotal = String.valueOf(list.get(i).getVentasTotalesUSD());
                dataRow.put("Id", id);
                dataRow.put("Vendedor", vendedor);
                dataRow.put("Cantidad Ventas", cantVentas);
                dataRow.put("Monto Total de Ventas", montoTotal);
                allData.add(dataRow);
        }
        return allData;
    }
}
