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
public class CategoriaTest {
    
    public CategoriaTest() {
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
     * Test of Buscar method, of class Categoria.
     */
    @Test
    public void testBuscar() {
        System.out.println("Buscar");
        Categoria instance = new Categoria();
        instance.Buscar();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of llenarSet method, of class Categoria.
     */
    @Test
    public void testLlenarSet() {
        Categoria instance = new Categoria();
        instance.c.conectar();
        String query = "SELECT DISTINCT Marca FROM Articulos";
        ResultSet rs= instance.c.obtenerSet(query);
        instance.llenarSet(rs);
        assertTrue(instance.getOptions().contains("Indurama"));
        assertTrue(instance.getOptions().contains("Durex"));
        assertTrue(instance.getOptions().contains("Mabe"));
        //
        assertFalse(instance.getOptions().contains("Honda"));
    }
    
}
