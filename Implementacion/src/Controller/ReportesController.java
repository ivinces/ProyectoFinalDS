/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.*;
import Model.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Fanny
 */
public class ReportesController {
    public ProcesosDB pdb;
    
    public ReportesController(){
        pdb.conectar("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDatabase");
    }
        
    public ArrayList<Articulo> BuscaArticulos() throws SQLException {
        ArrayList<Articulo> larticulo=new ArrayList<>();                   
        Date fecha=new Date(new Date().getTime()+TimeUnit.DAYS.toMillis(7));
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaQ=formatter.format(fecha);
        String fechaAct=formatter.format(new Date());
        String query = "SELECT Articulos.IDArticulos, Articulos.Nombre, COUNT(Ventas.IDArticulos) AS CantidadVentas, SUM(Articulos.Precio) AS VentasTotalesUSD FROM Lavadora, Refrigeradora, Cocina, Ventas, Articulos WHERE Articulos.IDArticulos=Refrigeradora.IDArticulos AND Articulos.IDArticulos=Lavadora.IDArticulos AND Articulos.IDArticulos=Cocina.IDArticulos AND Articulos.IDArticulos=Ventas.IDArticulos AND Ventas.Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
        ResultSet res= pdb.obtenerSet(query);
        Articulo art;
            while (res.next()){
                switch (res.getString("Nombre")) {
                    case "Lavadora":
                        art=new Lavadora(res.getString("IDArticulos"), res.getString("Nombre"));
                        larticulo.add(art);
                        break;
                    case "Cocina":
                        art=new Cocina(res.getString("IDArticulos"), res.getString("Nombre"));
                        larticulo.add(art);
                        break;
                    case "Refrigeradora":
                        art=new Refrigeradora(res.getString("IDArticulos"), res.getString("Nombre"));
                        larticulo.add(art);
                        break;
                    default:
                        break;
                }   
            }
        return larticulo;
    }
    
    public ArrayList<Ventas> BuscaVentas() throws SQLException {
        ArrayList<Ventas> lventas=new ArrayList<>();
        Date fecha=new Date(new Date().getTime()+TimeUnit.DAYS.toMillis(7));
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaQ=formatter.format(fecha);
        String fechaAct=formatter.format(new Date());
        String query = "SELECT Ventas.PrecioFinal, Ventas.Cantidad, Articulos.Nombre, Ventas.Fecha  FROM Lavadora, Refrigeradora, Cocina, Ventas, Articulos WHERE Articulos.IDArticulos=Refrigeradora.IDArticulos AND Articulos.IDArticulos=Lavadora.IDArticulos AND Articulos.IDArticulos=Cocina.IDArticulos AND Articulos.IDArticulos=Ventas.IDArticulos AND Ventas.Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
        ResultSet res= pdb.obtenerSet(query);
        Articulo art;
        Date fechaVent=new Date(res.getString("Fecha"));
        Ventas vent=new Ventas(res.getString("Nombre"),Integer.parseInt(res.getString("Cantidad")),fechaVent,Float.parseFloat(res.getString("PrecioFinal")));
        lventas.add(vent);
        return lventas;
    }
    
    public ArrayList<iVendedor> BuscaVendedor() throws SQLException {
        ArrayList<iVendedor> lvendedor=new ArrayList<>();
        Date fecha=new Date(new Date().getTime()+TimeUnit.DAYS.toMillis(7));
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaQ=formatter.format(fecha);
        String fechaAct=formatter.format(new Date());
        String query = "SELECT Vendedor.IDVendedor, Vendedor.Nombre, Vendedor.Apellido, COUNT(Ventas.IDVentas) AS CantidadVentas, SUM(Articulos.Precio) AS VentasTotalesUSD FROM Vendedor, Ventas, Articulos WHERE Vendedor.IDVendedor=Ventas.IDVendedor AND Articulos.IDArticulos=Ventas.IDArticulos AND Ventas.Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
        ResultSet res= pdb.obtenerSet(query);
        while (res.next()){
            iVendedor vend=new iVendedor(res.getString("IDVendedor"), res.getString("Nombre"), res.getString("Apellido"), Integer.parseInt(res.getString("CantidadVentas")),Float.parseFloat(res.getString("VentasTotalesUSD")), false);
                lvendedor.add(vend);
        }
        return lvendedor;
    }
    
    public ArrayList<Clientes> BuscaClientes() throws SQLException {
        ArrayList<Clientes> lClientes=new ArrayList<>();
        Date fecha=new Date(new Date().getTime()-TimeUnit.DAYS.toMillis(90));
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaQ=formatter.format(fecha);
        String fechaAct=formatter.format(new Date());
        String query = "SELECT Cliente.IDCliente, Cliente.Nombre, Cliente.Apellido, Cliente.Direccion, Cliente.Telefono, AVG(Articulos.Precio) AS MontoPromedio FROM Cliente, Ventas, Articulos WHERE Vendedor.IDVendedor=Ventas.IDVendedor AND Articulos.IDArticulos=Ventas.IDArticulos AND Ventas.Fecha BETWEEN "+fechaQ+" AND "+fechaAct;
        ResultSet res= pdb.obtenerSet(query);
        while (res.next()){
                Clientes clt=new Clientes(res.getString("Nombre"), res.getString("Apellido"), res.getString("IDCliente"),res.getString("Direccion"), res.getString("Telefono"), Float.parseFloat(res.getString("MontoPromedio")));
                lClientes.add(clt);
            }
        return lClientes;
    }
}
