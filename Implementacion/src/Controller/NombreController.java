/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CocinaIndurama;
import Model.LavadoraMabe;
import Model.LineaBlanca;
import Model.LineaBlancaAF;
import Model.Nombre;
import Model.RefrigeradoraDurex;
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
    LinkedList<LineaBlanca> articulos;
    VBox vb;
    Button anterior,siguiente,venta,cotizacion;
    int index;
    VBox Pane;
    Stage primaryStage;
    
    public NombreController(){
        articulos=new LinkedList<>();
        vb=new VBox();
    }

    public LinkedList<LineaBlanca> getArticulos() {
        return articulos;
    }

    public void setArticulos(LinkedList<LineaBlanca> articulos) {
        this.articulos = articulos;
    }
    
    public void buscar(ActionEvent e,VBox pane,Stage primaryStage,ComboBox cb){
        String com=(String) cb.getSelectionModel().getSelectedItem();
        this.Pane=pane;
        this.primaryStage=primaryStage;
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nombre.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection m_Connection;
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=ProyectoDS", "userid", "password");
            String query = "";
            switch (com) {
                case "Cocina":
                    query="SELECT * FROM Articulos,Cocina WHERE Articulo.IDArticulos=Cocina.IDArticulos";
                    break;
                case "Lavadora":
                    query="SELECT * FROM Articulos,Lavadora WHERE Articulo.IDArticulos=Lavadora.IDArticulos";
                    break;
                default:
                    query="SELECT * FROM Articulos,Refrigeradora WHERE Articulo.IDArticulos=Refrigeradora.IDArticulos";
                    break;
            }
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            if (m_ResultSet.next()){
                LineaBlancaAF articulo;
                switch (com) {
                    case "Cocina":
                        articulo=new CocinaIndurama();
                        break;
                    case "Lavadora":
                        articulo=new LavadoraMabe();
                        break;
                    default:
                        articulo=new RefrigeradoraDurex();
                        break;
                }
                String descripcion=m_ResultSet.getString("Color");
                LineaBlanca b=articulo.CrearArticulo();
                articulo.CrearArticulo().setDescripcion(descripcion);
                articulos.add(b);
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
        LineaBlanca lb=this.articulos.get(index);
        Label nombre=new Label("Nombre:     "+lb.getNombre());
        Label marca=new Label("Marca:      "+lb.getMarca());
        Label color=new Label("Color:      "+lb.getDescripcion());
        
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