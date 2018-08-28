/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author isabe
 */
public class ProcesosDBTest {
    
    public ProcesosDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class ProcesosDB.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        ProcesosDB instance = new ProcesosDB();
        instance.conectar();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerSet method, of class ProcesosDB.
     */
    @Test
    public void testObtenerSetVacio() throws SQLException {
        System.out.println("obtenerSet");
        String query = "SELECT DISTINCT Marca FROM Articulos";
        ProcesosDB instance = new ProcesosDB();
        instance.conectar();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerSet(query);
        System.out.println(result);
        assertNotNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    public void testObtenerSet() throws SQLException {
        System.out.println("obtenerSet");
        String query = "";
        ProcesosDB instance = new ProcesosDB();
        instance.conectar();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerSet(query);
        System.out.println(result);
        assertNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getM_Connection method, of class ProcesosDB.
     */
    
}
