/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedrito
 */
public class Conexion {
    Connection m_Connection;
    ResultSet m_ResultSet;

    public Conexion() {
    }
    
    public void conectar(String conex){
        try {
            m_Connection=DriverManager.getConnection(conex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet obtenerSet(String query){
        PreparedStatement pstmt;
        try {
            pstmt = m_Connection.prepareStatement(query);
            m_ResultSet = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m_ResultSet;       
    }
    
    public void llenar(){
        
    }
    
    
}
