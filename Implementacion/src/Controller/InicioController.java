package Controller;
import java.util.*;
import Model.*;
import View.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 */
public class InicioController {
    public Stage primaryStage;
    public String usuario,clave;
    
    public InicioController() {
    }

    /**
     * @param tipo
     */
    private void VerificarUsuario(String tipo) {
        Stage stage = new Stage();
        Scene scene;
        if(tipo.equals("Administrador")){
            AdministradorView c = new AdministradorView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        else if(tipo.equals("Gerente")){
            GerenteView c = new GerenteView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        
        else if(tipo.equals("SuperAdministrador")){
            SuperAdministradorView c = new SuperAdministradorView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        else{
            VendedorView c = new VendedorView(stage);
            scene = new Scene(c.getPane(), 500, 500);
        }
        
        stage.setTitle("Ingreso");
        stage.setScene(scene);
        primaryStage.hide();
        stage.show();
    }
    
    public void ingresar(ActionEvent e, Stage primaryStage,String usuario, String clave){
        this.primaryStage=primaryStage;
        this.usuario=usuario;
        this.clave=clave;
        String tipo="";
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nombre.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection m_Connection;
        try {
            m_Connection = DriverManager.getConnection(
                    "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=ProyectoDS", "userid", "password");
            String query = "SELECT Tipo FROM Usuarios,Vendedor,Administrador,"
                    + "SuperAdministrador,Gerente WHERE Usuarios.IDUsuarios=IDVendedor AND Usuarios.IDUsuarios=IDAdministrador"
                    + "AND Usuarios.IDUsuarios=IDSuperAdministrador AND Usuarios.IDUsuarios=IDGerente AND "
                    + "Usuario="+this.usuario+" AND Clave="+this.clave;
            PreparedStatement pstmt=m_Connection.prepareStatement(query);
            ResultSet m_ResultSet = pstmt.executeQuery();
            if (m_ResultSet.next()){
                tipo=m_ResultSet.getString("Tipo");
            }
            
        }  
        catch (SQLException ex) {
           
        }
        VerificarUsuario(tipo);
    }
}