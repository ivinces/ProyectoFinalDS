/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
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
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerSet method, of class ProcesosDB.
     */
    @Test
    public void testObtenerSet() {
        System.out.println("obtenerSet");
        String query = "";
        ProcesosDB instance = new ProcesosDB();
        ResultSet expResult = null;
        ResultSet result = instance.obtenerSet(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getM_Connection method, of class ProcesosDB.
     */
    @Test
    public void testGetM_Connection() {
        System.out.println("getM_Connection");
        ProcesosDB instance = new ProcesosDB();
        Connection expResult = null;
        Connection result = instance.getM_Connection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setM_Connection method, of class ProcesosDB.
     */
    @Test
    public void testSetM_Connection() {
        System.out.println("setM_Connection");
        Connection m_Connection = null;
        ProcesosDB instance = new ProcesosDB();
        instance.setM_Connection(m_Connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
