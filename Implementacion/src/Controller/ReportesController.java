/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.*;
import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fanny
 */
public class ReportesController {
    public Connection m_Connection;
    
    public ReportesController(){
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nombre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Articulo> BuscaArticulos() {
        ArrayList<Articulo> larticulo=new ArrayList<>();
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDatabase", "userid", "password");
            Date fecha=new Date(new Date().getTime()+TimeUnit.DAYS.toMillis(7));
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaQ=formatter.format(fecha);
            String fechaAct=formatter.format(new Date());
            String query = "SELECT Articulos.IDArticulos, Nombre.IDArticulos, COUNT(Ventas.IDArticulos) AS CantidadVentas, SUM(Articulos.Precio) AS VentasTotalesUSD FROM Lavadora, Refrigeradora, Cocina, Ventas, Articulos WHERE Articulos.IDArticulos=Refrigeradora.IDArticulos AND Articulos.IDArticulos=Lavadora.IDArticulos AND Articulos.IDArticulos=Cocina.IDArticulos AND Articulos.IDArticulos=Ventas.IDArticulos AND Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            Articulo art;
            if (m_ResultSet.next()){
                switch (m_ResultSet.getString("Nombre")) {
                    case "Lavadora":
                        art=new Lavadora(m_ResultSet.getString("IDArticulos"), m_ResultSet.getString("Nombre"), Integer.parseInt(m_ResultSet.getString("CantidadVentas")),Float.parseFloat(m_ResultSet.getString("VentasTotalesUSD")));
                        larticulo.add(art);
                        break;
                    case "Cocina":
                        art=new Cocina(m_ResultSet.getString("IDArticulos"), m_ResultSet.getString("Nombre"), Integer.parseInt(m_ResultSet.getString("CantidadVentas")),Float.parseFloat(m_ResultSet.getString("VentasTotalesUSD")));
                        larticulo.add(art);
                        break;
                    case "Refrigeradora":
                        art=new Refrigeradora(m_ResultSet.getString("IDArticulos"), m_ResultSet.getString("Nombre"), Integer.parseInt(m_ResultSet.getString("CantidadVentas")),Float.parseFloat(m_ResultSet.getString("VentasTotalesUSD")));
                        larticulo.add(art);
                        break;
                    default:
                    break;
                }   
            }
        } 
        catch (SQLException ex) {
        }
        return larticulo;
    }
    
    public ArrayList<iVendedor> BuscaVendedor() {
        ArrayList<iVendedor> lvendedor=new ArrayList<>();
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDatabase", "userid", "password");
            Date fecha=new Date(new Date().getTime()+TimeUnit.DAYS.toMillis(7));
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaQ=formatter.format(fecha);
            String fechaAct=formatter.format(new Date());
            String query = "SELECT Vendedor.IDVendedor, Vendedor.Nombre, Vendedor.Apellido, COUNT(Ventas.IDVentas) AS CantidadVentas, SUM(Articulos.Precio) AS VentasTotalesUSD FROM Vendedor, Ventas, Articulos WHERE Vendedor.IDVendedor=Ventas.IDVendedor AND Articulos.IDArticulos=Ventas.IDArticulos AND Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            if (m_ResultSet.next()){
                iVendedor vend=new iVendedor(m_ResultSet.getString("IDVendedor"), m_ResultSet.getString("Nombre"), m_ResultSet.getString("Apellido"), Integer.parseInt(m_ResultSet.getString("CantidadVentas")),Float.parseFloat(m_ResultSet.getString("VentasTotalesUSD")), false);
                lvendedor.add(vend);
            }
            
        } 
        catch (SQLException ex) {
        }
        return lvendedor;
    }
    
    public ArrayList<Clientes> BuscaClientes() {
        ArrayList<Clientes> lClientes=new ArrayList<>();
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDatabase", "userid", "password");
            Date fecha=new Date(new Date().getTime()-TimeUnit.DAYS.toMillis(90));
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaQ=formatter.format(fecha);
            String fechaAct=formatter.format(new Date());
            String query = "SELECT Cliente.IDCliente, Cliente.Nombre, Cliente.Apellido, Cliente.Direccion, Cliente.Telefono, AVG(Articulos.Precio) AS MontoPromedio FROM Cliente, Ventas, Articulos WHERE Vendedor.IDVendedor=Ventas.IDVendedor AND Articulos.IDArticulos=Ventas.IDArticulos AND Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            if (m_ResultSet.next()){
                Clientes clt=new Clientes(m_ResultSet.getString("Nombre"), m_ResultSet.getString("Apellido"), m_ResultSet.getString("IDCliente"), m_ResultSet.getString("Direccion"), m_ResultSet.getString("Telefono"), Float.parseFloat(m_ResultSet.getString("MontoPromedio")));
                lClientes.add(clt);
            }
            
        } 
        catch (SQLException ex) {
        }
        return lClientes;
    }
}
