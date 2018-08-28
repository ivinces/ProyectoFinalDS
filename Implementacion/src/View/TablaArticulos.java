/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Articulo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author isabe
 */
public class TablaArticulos {
    
    private VBox vb1;
    private TableView table1;
    private final String id="IDArticulo";
    private final String nombre="Nombre";
    private final String marca="Marca";
    private final String modelo="Modelo";
    private final String precio="Precio";
    private final String color="Color";
                            
   
   public VBox TablaOferta(ArrayList<Articulo> list) {
        
        table1 = new TableView(generateDataInMap(list));
        vb1= new VBox();
        table1.setEditable(true);
        
        TableColumn<Map, String> idar = new TableColumn<>("IDArticulo");
        TableColumn<Map, String> nom= new TableColumn<>("Nombre");
        TableColumn<Map, String> mar = new TableColumn<>("Marca");
        TableColumn<Map, String> mode = new TableColumn<>("Modelo");
        TableColumn<Map, String> prec= new TableColumn<>("Precio");
        TableColumn<Map, String> colo= new TableColumn<>("Color");
        
        
        idar.setCellValueFactory(new MapValueFactory(id));
        idar.setMinWidth(100);
        nom.setCellValueFactory(new MapValueFactory(nombre));
        nom.setMinWidth(100);
        mar.setCellValueFactory(new MapValueFactory(marca));
        mar.setMinWidth(100);
        mode.setCellValueFactory(new MapValueFactory(modelo));
        mode.setMinWidth(100);
        prec.setCellValueFactory(new MapValueFactory(precio));
        prec.setMinWidth(100);
        colo.setCellValueFactory(new MapValueFactory(color));
        colo.setMinWidth(100);
        

        table1.getColumns().addAll(idar,nom,mar,mode,prec,colo);
        
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
        
        idar.setCellFactory(cellFactoryForMap);
        nom.setCellFactory(cellFactoryForMap);
        mar.setCellFactory(cellFactoryForMap);
        mode.setCellFactory(cellFactoryForMap);
        prec.setCellFactory(cellFactoryForMap);
        colo.setCellFactory(cellFactoryForMap);
        
        
        //SetStyleTable(table1, correo,oferta);
        
        vb1.setSpacing(3);
        vb1.setPadding(new Insets(10, 0, 0, 0));
        vb1.getChildren().addAll(table1);
            
        return vb1;
    }

    private ObservableList generateDataInMap(ArrayList<Articulo> list) {

        ObservableList<Map> allData = FXCollections.observableArrayList();

            for (int i = 0; i < list.size(); i++) {
                Map<String, String> dataRow = new HashMap<>();

                String value1 = list.get(i).getId();
                String value2 = list.get(i).getNombre();
                String value3 = list.get(i).getMarca();
                String value4 = list.get(i).getModelo();
                String value5 = String.valueOf(list.get(i).getPrecio());
                String value6 = list.get(i).getColor();
                
                dataRow.put(this.id, value1);
                dataRow.put(nombre, value2);
                dataRow.put(marca, value3);
                dataRow.put(modelo, value4);
                dataRow.put(precio, value5);
                dataRow.put(color, value6);
                
                
                allData.add(dataRow);
            
        }
        return allData;
    }
        
    
    
    
}
