package View;
import Model.*;
import java.util.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 
 */
public class AdministradorView {
    public iAdministrador Model;
    public HBox Pane;
    private Stage primaryStage;
    /**
     * Default constructor
     * @param primaryStage
     */
    public HBox getPane() {
        return Pane;
    }
    
    public AdministradorView(Stage primaryStage) {
        this.primaryStage=primaryStage;
    }

    /**
     * 
     */
    
    


    /**
     * @param model
     */
    public void AdministradorView(iAdministrador model) {
        // TODO implement here
    }

}