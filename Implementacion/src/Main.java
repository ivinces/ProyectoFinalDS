import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import View.Inicio;
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

    public void start(Stage primaryStage) throws Exception {
        Inicio org = new Inicio(primaryStage);
        //NuevasPreguntas org= new NuevasPreguntas(primaryStage,null);
        Scene scene = new Scene(org.getPane(), 500, 500);
      
        primaryStage.setTitle("Linea Blanca S.A");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}