/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import javafx.collections.ObservableList;
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
public class DescripciónTest {
    
    public DescripciónTest() {
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
     * Test of getOptions method, of class Descripción.
     */
    @Test
    public void testGetOptions() {
        System.out.println("getOptions");
        Descripción instance = new Descripción();
        ObservableList<String> result = instance.getOptions();
        assertNotNull(result);
    }
    
    /**
     * Test of setOptions method, of class Descripción.
     */
    @Test
    public void testSetOptions() {
        System.out.println("setOptions");
        ObservableList<String> options = null;
        Descripción instance = new Descripción();
        instance.setOptions(options);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Buscar method, of class Descripción.
     */
    @Test
    public void testBuscar() {
        System.out.println("Buscar");
        Descripción instance = new Descripción();
        instance.Buscar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarSet method, of class Descripción.
     */
    @Test
    public void testLlenarSet() {
        System.out.println("llenarSet");
        ResultSet rs = null;
        Descripción instance = new Descripción();
        instance.llenarSet(rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
