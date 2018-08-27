/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BusquedaView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author isabe
 */
public class Ventas_Privilegios_Controller extends PrivilegiosController{

    public Ventas_Privilegios_Controller() {
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
    
    public void actualizarVentas(ActionEvent e) {
        
    }
    
    public void eliminarVentas(ActionEvent e) {
        
    }
    
    
    
}
