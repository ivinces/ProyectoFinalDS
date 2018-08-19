/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ReporteArticulo;
import Model.ReporteCliente;
import Model.ReporteVendedor;
import Model.Reportes;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controller.ReportesController;
import Model.Clientes;
import Model.LineaBlancaAF;
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
    
    
    /**
     * Default constructor
     */
    public ReportesView(Stage primaryStage) {
        this.primaryStage=primaryStage;
        Pane=new VBox();
    }
    
    
    public void organize(){
        Label lbreporte=new Label("Reportes");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
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
        Pane.getChildren().addAll(lbreporte,cmb);
        VBox vbreportes=new VBox();
        vbreportes.getChildren().addAll(bbuscar);
        Pane.getChildren().addAll(vbreportes);
        Stage stage=new Stage();
        VBox vboton= new VBox();
        bbuscar.setOnAction((e)->{buscar(e,stage,vboton);});
        Scene scene = new Scene(vboton, 300, 300);
        primaryStage.setTitle("Reportes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void buscar(ActionEvent e, Stage primarystage, VBox vboton){
        String tipoBusqueda=(String)this.cmb.getSelectionModel().getSelectedItem();
        tv.setEditable(true);
        if("Reportes por Ventas Vendedor".equals(tipoBusqueda)){
            reportesVendedorView(vboton);
        }
        else if("Reportes por Artículos".equals(tipoBusqueda)){
            reportesArticuloView(vboton);
        }
        else if("Reportes por Clientes".equals(tipoBusqueda)){
            reportesClientesView(vboton);
        }
    }

    public void reportesVendedorView(VBox vboton){
        Label lbreporte=new Label("Reportes Vendores");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id = new TableColumn<>("Id");
        TableColumn<Map, String> vendedor = new TableColumn<>("Vendedor");
        TableColumn<Map, String> cantidadVentas = new TableColumn<>("Cantidad Ventas");
        TableColumn<Map, String> montoTotalVentas = new TableColumn<>("Monto Total de Ventas");
        tv.getColumns().addAll(id, vendedor, cantidadVentas, montoTotalVentas);
        ArrayList<iVendedor> list= new ReportesController().BuscaVendedor();
        tv = new TableView(generateDataInMapVendedor(list));
        vboton.getChildren().addAll(lbreporte,tv);
    }
    
    public void reportesArticuloView(VBox vboton){
        Label lbreporte=new Label("Reportes Articulos");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id  = new TableColumn<>("Id");
        TableColumn<Map, String> cantidad  = new TableColumn<>("Cantidad");
        TableColumn<Map, String> articulo  = new TableColumn<>("Articulo");
        TableColumn<Map, String> ventaTotalUSD = new TableColumn<>("Ventas Totales en Dolares");
        tv.getColumns().addAll(id, cantidad, articulo, ventaTotalUSD);
        ArrayList<Clientes> list= new ReportesController().BuscaClientes();
        tv = new TableView(generateDataInMapClientes(list));
        vboton.getChildren().addAll(lbreporte,tv);
    }
    
    public void reportesClientesView(VBox vboton){
        Label lbreporte=new Label("Reportes Clientes");
        lbreporte.setAlignment(Pos.CENTER);
        lbreporte.setUnderline(true);
        TableColumn<Map, String> id = new TableColumn("Id");
        TableColumn<Map, String> nombres = new TableColumn("Nombres");
        TableColumn<Map, String> direccion = new TableColumn("Direccion");
        TableColumn<Map, String> telefono = new TableColumn("Telefono");
        TableColumn<Map, String> montoPromedioMensual = new TableColumn("Monto promedio mensual del último trimestre");
        tv.getColumns().addAll(id, nombres, direccion, telefono, montoPromedioMensual);
        ArrayList<LineaBlancaAF> list= new ReportesController().BuscaArticulos();
        tv = new TableView(generateDataInMapArticulos(list));
        vboton.getChildren().addAll(lbreporte,tv);
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
    
    private ObservableList generateDataInMapArticulos(ArrayList<LineaBlancaAF> list) {        
        ObservableList<Map> allData = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> dataRow = new HashMap<>();
                String id = list.get(i).getId();
                String cantidad = String.valueOf(list.get(i).getCantidadVentas());
                String articulo = list.get(i).getArticulo();
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