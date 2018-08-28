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
        pdb=new ProcesosDB();
        pdb.conectar();
    }
        
    public ArrayList<Articulo> BuscaArticulos() throws SQLException {
        ArrayList<Articulo> larticulo=new ArrayList<>();
        String query = "SELECT Articulos.IDArticulos, Articulos.Color, Articulos.Nombre, Articulos.Marca, Articulos.Precio, Articulos.modelo, COUNT(Ventas.IDArticulos) AS CantidadVentas, SUM(Articulos.Precio) AS VentasTotalesUSD FROM Lavadoras, Refrigeradoras, Cocinas, Ventas, Articulos WHERE Articulos.IDArticulos=Refrigeradoras.IDArticulos OR Articulos.IDArticulos=Lavadoras.IDArticulos OR Articulos.IDArticulos=Cocinas.IDArticulos AND Articulos.IDArticulos=Ventas.IDArticulos GROUP BY Articulos.IDArticulos";
        ResultSet res= pdb.obtenerSet(query);
        Articulo art;
            /*while (res.next()){
                switch (res.getString("Nombre")) {
                    case "Lavadora":
                        art=new Lavadora(res.getString("IDArticulos"), res.getString("Color"), res.getString("Nombre"), res.getString("Marca"), Float.parseFloat(res.getString("Precio")), res.getString("Modelo"));
                        larticulo.add(art);
                        break;
                    case "Cocina":
                        art=new Cocina(res.getString("IDArticulos"), res.getString("Color"), res.getString("Nombre"), res.getString("Marca"), Float.parseFloat(res.getString("Precio")), res.getString("Modelo"));
                        larticulo.add(art);
                        break;
                    case "Refrigeradora":
                        art=new Refrigeradora(res.getString("IDArticulos"), res.getString("Color"), res.getString("Nombre"), res.getString("Marca"), Float.parseFloat(res.getString("Precio")), res.getString("Modelo"));
                        larticulo.add(art);
                        break;
                    default:
                        break;
                }   
            }*/
        return larticulo;
    }
    
    public ArrayList<Ventas> BuscaVentas() throws SQLException {
        ArrayList<Ventas> lventas=new ArrayList<>();
        String query = "SELECT Ventas.PrecioFinal, Ventas.Cantidad, Articulos.Nombre, Ventas.Fecha  FROM Ventas, Articulos WHERE Articulos.IDArticulos=Ventas.IDArticulos";
        ResultSet res= pdb.obtenerSet(query);
        Ventas vent=new Ventas(res.getString("Nombre"),Integer.parseInt(res.getString("Cantidad")),Float.parseFloat(res.getString("PrecioFinal")));
        lventas.add(vent);
        return lventas;
    }
    
    public ArrayList<iVendedor> BuscaVendedor() throws SQLException {
        ArrayList<iVendedor> lvendedor=new ArrayList<>();
        String query = "SELECT Vendedor.IDVendedor, Vendedor.Nombre, Vendedor.Apellido, COUNT(Ventas.IDVentas) AS CantidadVentas, SUM(Articulos.Precio) AS VentasTotalesUSD FROM Vendedor, Ventas, Articulos WHERE Vendedor.IDVendedor=Ventas.IDVendedor AND Articulos.IDArticulos=Ventas.IDArticulos GROUP BY Vendedor.IDVendedor";
        ResultSet res= pdb.obtenerSet(query);
        while (res.next()){
            iVendedor vend=new iVendedor(res.getString("IDVendedor"), res.getString("Nombre"), res.getString("Apellido"), Integer.parseInt(res.getString("CantidadVentas")),Float.parseFloat(res.getString("VentasTotalesUSD")), false);
                lvendedor.add(vend);
        }
        return lvendedor;
    }
    
    public ArrayList<Clientes> BuscaClientes() throws SQLException {
        ArrayList<Clientes> lClientes=new ArrayList<>();
        String query = "SELECT Cliente.IDCliente, Cliente.Nombre, Cliente.Apellido, Cliente.Direccion, Cliente.Telefono, AVG(Articulos.Precio) AS MontoPromedio FROM Cliente, Ventas, Articulos WHERE Articulos.IDArticulos=Ventas.IDArticulos GROUP BY Cliente.IDCliente";
        ResultSet res= pdb.obtenerSet(query);
        while (res.next()){
                Clientes clt=new Clientes(res.getString("Nombre"), res.getString("Apellido"), res.getString("IDCliente"),res.getString("Direccion"), res.getString("Telefono"), Float.parseFloat(res.getString("MontoPromedio")));
                lClientes.add(clt);
            }
        return lClientes;
    }
}
