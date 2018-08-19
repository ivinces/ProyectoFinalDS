import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import View.*;
import javafx.scene.Scene;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isabe
 */
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Inicio org = new Inicio(primaryStage);
        VendedorView org= new  VendedorView(primaryStage);
        Scene scene = new Scene(org.getPane(), 300, 300);
      
        primaryStage.setTitle("Linea Blanca S.A");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
