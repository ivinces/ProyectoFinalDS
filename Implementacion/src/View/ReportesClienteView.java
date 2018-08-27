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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    
    public void reportesClientesView(VBox vboton,TableView tv) throws SQLException{
        Label lbreporte=new Label("Reportes Clientes");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id = new TableColumn("Id");
        TableColumn<Map, String> nombres = new TableColumn("Nombres");
        TableColumn<Map, String> direccion = new TableColumn("Direccion");
        TableColumn<Map, String> telefono = new TableColumn("Telefono");
        TableColumn<Map, String> montoPromedioMensual = new TableColumn("Monto promedio mensual del último trimestre");
        tv.getColumns().addAll(id, nombres, direccion, telefono, montoPromedioMensual);
        ArrayList<Clientes> list= new ReportesController().BuscaClientes();
        tv = new TableView(generateDataInMapClientes(list));
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
