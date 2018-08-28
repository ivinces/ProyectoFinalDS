/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class NombreTest {
    
    public NombreTest() {
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
     * Test of getOptions method, of class Nombre.
     */
    @Test
    public void testGetOptionsNotNull() {
        System.out.println("getOptions");
        Nombre instance = new Nombre();
        ObservableList<String> result = instance.getOptions();
        assertNotNull(result);
    }

    /**
     * Test of setOptions method, of class Nombre.
     */
    @Test
    public void testSetOptions() {
        System.out.println("setOptions");
        ObservableList<String> options = null;
        Nombre instance = new Nombre();
        instance.setOptions(options);
    }
    
}
