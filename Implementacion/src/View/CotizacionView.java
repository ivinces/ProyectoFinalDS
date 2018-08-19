package View;
import Model.*;
import java.util.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */
public class CotizacionView {
    public Cotizacion Model;
    public VBox Pane;
    
    /**
     * Default constructor
     */
    public CotizacionView() {
    }
    public VBox getPane(){
        return Pane;
    }

    /**
     * @param primaryStage
     */
    public CotizacionView(Stage primaryStage) {
        // TODO implement here
    }

}