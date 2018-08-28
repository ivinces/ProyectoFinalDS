/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportesController;
import Model.Articulo;
import Model.Clientes;
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
public class ReportesClienteView {
    
    public VBox Pane;
    public Stage primaryStage;
    public Label label;
    
    public ReportesClienteView(Stage primaryStage) {
        Pane = new VBox();
        label=new Label("Reportes Vendedor");
        label.setAlignment(Pos.CENTER);
        this.primaryStage=primaryStage;
        Pane.getChildren().add(label);
    }
    
    public void reportesClientesView(VBox vboton,TableView tv, VBox Pane) throws SQLException{
        ArrayList<Clientes> list= new ReportesController().BuscaClientes();
        tv = new TableView(generateDataInMapClientes(list));
        Label lbreporte=new Label("Reportes Clientes");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id = new TableColumn("Id");
        TableColumn<Map, String> nombres = new TableColumn("Nombres");
        TableColumn<Map, String> direccion = new TableColumn("Direccion");
        TableColumn<Map, String> telefono = new TableColumn("Telefono");
        TableColumn<Map, String> montoPromedioMensual = new TableColumn("Monto promedio mensual del último trimestre");
        
        id.setCellValueFactory(new MapValueFactory("Id"));
        id.setMinWidth(100);
        nombres.setCellValueFactory(new MapValueFactory("Nombres"));
        nombres.setMinWidth(100);
        direccion.setCellValueFactory(new MapValueFactory("Direccion"));
        direccion.setMinWidth(100);
        telefono.setCellValueFactory(new MapValueFactory("Telefono"));
        telefono.setMinWidth(100);
        montoPromedioMensual.setCellValueFactory(new MapValueFactory("Monto promedio mensual del último trimestre"));
        montoPromedioMensual.setMinWidth(100);
        
        tv.getColumns().addAll(id, nombres, direccion, telefono, montoPromedioMensual);
        
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
        nombres.setCellFactory(cellFactoryForMap);
        direccion.setCellFactory(cellFactoryForMap);
        telefono.setCellFactory(cellFactoryForMap);
        montoPromedioMensual.setCellFactory(cellFactoryForMap);
        
        vboton.getChildren().addAll(lbreporte,tv);
        Pane.getChildren().add(vboton);
        
    }
    
    private ObservableList generateDataInMapClientes(ArrayList<Clientes> list) {        
        ObservableList<Map> allData = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> dataRow = new HashMap<>();
                String id = list.get(i).getId();
                String nombres = list.get(i).getNombres()+" "+list.get(i).getApellidos();
                String direccion = list.get(i).getDireccion();
                String telefono = list.get(i).getTelefono();
                String montoPromedioMensual = String.valueOf(list.get(i).getMontoPromedio());
                dataRow.put("Id", id);
                dataRow.put("Nombres", nombres);
                dataRow.put("Direccion", direccion);
                dataRow.put("Telefono", telefono);
                dataRow.put("Monto promedio mensual del último trimestre", montoPromedioMensual);
                allData.add(dataRow);
        }
        return allData;
    }
    
}
