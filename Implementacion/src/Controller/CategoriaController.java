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
import java.util.ArrayList;
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
public class CategoriaController {
    LinkedList<Articulo> articulos;
    VBox vb;
    Button anterior,siguiente,venta,cotizacion;
    int index;
    VBox Pane;
    Stage primaryStage;
    ProcesosDB pdb;
    
    public CategoriaController(){
        articulos=new LinkedList<>();
        vb=new VBox();
        pdb=new ProcesosDB();
    }

    public LinkedList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(LinkedList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    public void buscar(ActionEvent e,VBox pane,Stage primaryStage,ComboBox cb) throws SQLException{
        String com=(String) cb.getSelectionModel().getSelectedItem();
        this.Pane=pane;
        this.primaryStage=primaryStage;
        
        try{
        pdb.conectar();
            String query = "SELECT * FROM Articulos WHERE Articulo.Marca="+com;
            ResultSet r = pdb.obtenerSet(query);
            if (r.next()){
                Articulo articulo;
                String marca=r.getString("Marca");
                switch (marca) {
                    case "Indurama":
                        articulo=new Cocina(r.getString("IDArticulos"),r.getString("Color"),r.getString("Nombre"),r.getString("Marca"),
                        Float.parseFloat(r.getString("Precio")),r.getString("Modelo"));
                        articulos.add(articulo);
                        break;
                    case "Mabe":
                        articulo=new Lavadora(r.getString("IDArticulos"),r.getString("Color"),r.getString("Nombre"),r.getString("Marca"),
                        Float.parseFloat(r.getString("Precio")),r.getString("Modelo"));
                        articulos.add(articulo);
                        break;
                    default:
                        articulo=new Refrigeradora(r.getString("IDArticulos"),r.getString("Color"),r.getString("Nombre"),r.getString("Marca"),
                        Float.parseFloat(r.getString("Precio")),r.getString("Modelo"));
                        articulos.add(articulo);
                        break;
                }
                /*String descripcion=m_ResultSet.getString("Color");
                Articulo b = new Articulo();
                b.setDescripcion(descripcion);
                articulos.add(b);*/
            }
            
        }  
        catch (SQLException ex) {
           
        }
    
    }
    public void nuevo(){
        anterior=new Button("Anterior");
        anterior.setOnAction(e->banterior(e));
        siguiente=new Button("Siguiente");
        siguiente.setOnAction(e->bsiguiente(e));
        HBox h=new HBox();
        h.getChildren().addAll(anterior,agregarinfo(this.index),siguiente);
        Pane.getChildren().addAll(h);
    }
    
    public VBox agregarinfo(int index){
        VBox vbtemp=new VBox();
        Articulo lb=this.articulos.get(index);
        Label nombre=new Label("Nombre:     "+lb.getNombre());
        Label marca=new Label("Marca:      "+lb.getMarca());
        Label color=new Label("Color:      "+lb.getColor());
        
        venta=new Button("Hacer una venta");
        cotizacion=new Button("Hacer una cotizacion");
        HBox hb=new HBox();
        hb.getChildren().addAll(venta,cotizacion);
        vbtemp.getChildren().addAll(nombre,marca,color,hb);
        return vbtemp;
    }
    
    public void banterior(ActionEvent e) {
        this.index--;
        if(this.index<0)
            this.index=this.articulos.size()-1;
        this.vb.getChildren().clear();
        this.vb.getChildren().addAll(anterior,agregarinfo(this.index),siguiente);
    }
    
    public void bsiguiente(ActionEvent e){
        this.index++;
        if(this.index>this.articulos.size()-1)
            this.index=0;
        
        this.vb.getChildren().clear();
        this.vb.getChildren().addAll(anterior,agregarinfo(this.index),siguiente);
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
