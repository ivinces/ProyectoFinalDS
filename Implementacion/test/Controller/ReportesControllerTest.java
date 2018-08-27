/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Articulo;
import Model.Clientes;
import Model.Ventas;
import Model.iVendedor;
import java.util.ArrayList;
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
public class ReportesControllerTest {
    
    public ReportesControllerTest() {
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
     * Test of BuscaArticulos method, of class ReportesController.
     */
    @Test
    public void testBuscaArticulos() throws Exception {
        System.out.println("BuscaArticulos");
        ReportesController instance = new ReportesController();
        ArrayList<Articulo> expResult = null;
        ArrayList<Articulo> result = instance.BuscaArticulos();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscaVentas method, of class ReportesController.
     */
    @Test
    public void testBuscaVentas() throws Exception {
        System.out.println("BuscaVentas");
        ReportesController instance = new ReportesController();
        ArrayList<Ventas> expResult = null;
        ArrayList<Ventas> result = instance.BuscaVentas();
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscaVendedor method, of class ReportesController.
     */
    @Test
    public void testBuscaVendedor() throws Exception {
        System.out.println("BuscaVendedor");
        ReportesController instance = new ReportesController();
        ArrayList<iVendedor> expResult = null;
        ArrayList<iVendedor> result = instance.BuscaVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscaClientes method, of class ReportesController.
     */
    @Test
    public void testBuscaClientes() throws Exception {
        System.out.println("BuscaClientes");
        ReportesController instance = new ReportesController();
        ArrayList<Clientes> expResult = null;
        ArrayList<Clientes> result = instance.BuscaClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
