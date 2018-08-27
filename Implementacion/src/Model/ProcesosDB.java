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
public class ProcesosDB {
    private Connection m_Connection;
    ResultSet m_ResultSet;

    public ProcesosDB(){
    }
    
    public void conectar(){
        try {
            System.out.println("ENTRO XD");
            m_Connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Name;integratedSecurity=true;");
            System.out.println("HIZO ALGO XDDD");
        } catch (SQLException ex) {
            Logger.getLogger(ProcesosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet obtenerSet(String query){
        PreparedStatement pstmt;
        try {
            pstmt = m_Connection.prepareStatement(query);
            m_ResultSet = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m_ResultSet;
    }
    

    public Connection getM_Connection() {
        return m_Connection;
    }

    public void setM_Connection(Connection m_Connection) {
        this.m_Connection = m_Connection;
    }
  

}
