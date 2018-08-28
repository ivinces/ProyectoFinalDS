/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Articulo;
import Model.Cocina;
import Model.Lavadora;
import Model.Nombre;
import Model.ProcesosDB;
import Model.Refrigeradora;
import View.CotizacionView;
import View.VentaView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author isabe
 */
public class NombreController {
    LinkedList<Articulo> articulos;
    VBox vb;
    Button anterior,siguiente,venta,cotizacion;
    int index;
    Stage primaryStage;
    ProcesosDB c;
    
    public NombreController(){
        c=new ProcesosDB();
        articulos=new LinkedList<>();
        vb=new VBox();
    }

    public LinkedList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(LinkedList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    public void buscar(ActionEvent e,VBox pane,Stage primaryStage,ComboBox cb){
        String com=(String) cb.getSelectionModel().getSelectedItem();
        
        try {
            c.conectar();
            String query = "";
            switch (com) {
                case "Cocina":
                    
                    query="SELECT * FROM Articulos,Cocinas WHERE Articulos.IDArticulos=Cocinas.IDArticulos";
                    break;
                case "Lavadora":
                    query="SELECT * FROM Articulos,Lavadoras WHERE Articulos.IDArticulos=Lavadoras.IDArticulos";
                    break;
                case "Refrigeradora":
                    query="SELECT * FROM Articulos,Refrigeradoras WHERE Articulos.IDArticulos=Refrigeradoras.IDArticulos";
                    break;
            }
            
            ResultSet r = c.obtenerSet(query);
            while (r.next()){
                Articulo articulo;
                switch (com) {
                    case "Cocina":
                        articulo=new Cocina(r.getString("IDArticulos"),r.getString("Color"),r.getString("Nombre"),r.getString("Marca"),
                        Float.parseFloat(r.getString("Precio")),r.getString("Modelo"));
                        articulos.add(articulo);
                        break;
                    case "Lavadora":
                        articulo=new Lavadora(r.getString("IDArticulos"),r.getString("Color"),r.getString("Nombre"),r.getString("Marca"),
                        Float.parseFloat(r.getString("Precio")),r.getString("Modelo"));
                        articulos.add(articulo);
                        break;
                    case "Refrigeradora":
                        articulo=new Refrigeradora(r.getString("IDArticulos"),r.getString("Color"),r.getString("Nombre"),r.getString("Marca"),
                        Float.parseFloat(r.getString("Precio")),r.getString("Modelo"));
                        articulos.add(articulo);
                        break;
                }
          
            }
            
        }  
        catch (SQLException ex) {
           
        }
      pane.getChildren().clear();
        nuevo(pane);
    }
    
    public void nuevo(VBox Pane){
        Pane.getChildren().clear();
        HBox h=new HBox();
        h.getChildren().clear();
        h.getChildren().addAll(agregarinfo(this.index));
        VBox nu=new VBox();
        nu.getChildren().clear();
        nu.getChildren().add(h);
        Pane.getChildren().clear();
        Pane.getChildren().addAll(nu);
    }
    
    public VBox agregarinfo(int index){
        VBox total=new VBox();
        
        for(Articulo lb:this.articulos){
            VBox vbtemp=new VBox();
            Label nombre=new Label("Nombre:     "+lb.getNombre());
            Label marca=new Label("Marca:      "+lb.getMarca());
            Label color=new Label("Color:      "+lb.getColor());

            venta=new Button("Hacer una venta");
            cotizacion=new Button("Hacer una cotizacion");
            HBox hb=new HBox();
            hb.getChildren().addAll(venta,cotizacion);
            vbtemp.getChildren().addAll(nombre,marca,color,hb);
        
            total.getChildren().add(vbtemp);
        
        }
        return total;
    }
    
    public void bventas(ActionEvent e){
        VentaView ventas=new VentaView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(ventas.getPane(), 500, 500);
        stage.setTitle("Realizar una Venta");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }
    
    public void bcotizacion(ActionEvent e){
        CotizacionView ventas=new CotizacionView(primaryStage);
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(ventas.getPane(), 500, 500);
        stage.setTitle("Realizar una Cotizacion");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }
    
}
