/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ReportesView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author isabe
 */
public class Repor_Privilegios_Controller extends PrivilegiosController{

    public Repor_Privilegios_Controller() {
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
    
    public void eliminarReportes(ActionEvent e) {
        
    }
    
    
    
}
