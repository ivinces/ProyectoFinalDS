/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Reportes;
import View.BusquedaView;
import View.ReportesView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author isabe
 */
public class PrivilegiosController {

    public PrivilegiosController() {
    }
    
    public void crearUsuario(ActionEvent e){
        
    }

    public void crearProducto(ActionEvent e) {
        
    }

    public void crearVentas(ActionEvent e,Stage primaryStage) {
        BusquedaView busview=new BusquedaView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(busview.getPane(), 500, 500);
        stage.setTitle("Busqueda");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
        
    }

    public void crearClientes(ActionEvent e) {
        
    }

    public void crearCotizacion(ActionEvent e,Stage primaryStage) {
        BusquedaView busview=new BusquedaView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(busview.getPane(), 500, 500);
        stage.setTitle("Busqueda");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
        
    }
    
    public void actualizarUsuario(ActionEvent e){
        
    }

    public void actualizarProducto(ActionEvent e) {
        
    }

    public void actualizarVentas(ActionEvent e) {
        
    }

    public void actualizarClientes(ActionEvent e) {
        
    }

    public void verUsuario(ActionEvent e,Stage primaryStage){
        
    }

    public void verProducto(ActionEvent e,Stage primaryStage) {
        BusquedaView busview=new BusquedaView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(busview.getPane(), 500, 500);
        stage.setTitle("Busqueda");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }

    public void verReportes(ActionEvent e,Stage primaryStage) {
        ReportesView review=new ReportesView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(review.getPane(), 500, 500);
        stage.setTitle("Reportes");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
        
    }

    public void verClientes(ActionEvent e) {
        
    }

    public void verCotizacion(ActionEvent e,Stage primaryStage) {
        BusquedaView busview=new BusquedaView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(busview.getPane(), 500, 500);
        stage.setTitle("Busqueda");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }
    
    public void eliminarUsuario(ActionEvent e){
        
    }

    public void eliminarProducto(ActionEvent e) {
        
    }

    public void eliminarConsultas(ActionEvent e) {
        
    }

    public void eliminarReportes(ActionEvent e) {
        
    }

    public void eliminarVentas(ActionEvent e) {
        
    }

    public void eliminarClientes(ActionEvent e) {
        
    }

    public void eliminarCotizacion(ActionEvent e) {
        
    }
    
}
