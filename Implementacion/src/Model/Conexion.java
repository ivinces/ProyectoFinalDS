/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedrito
 */
public class Conexion {
    private Connection m_Connection;

    public Conexion() {
    }
    
    public void conectar(String conex){
        try {
            m_Connection=DriverManager.getConnection(conex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public Connection getM_Connection() {
        return m_Connection;
    }

    public void setM_Connection(Connection m_Connection) {
        this.m_Connection = m_Connection;
    }
  

}
