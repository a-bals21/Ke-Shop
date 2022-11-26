/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tnt.cajero;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tnt.publicacion.Publicacion;

/**
 *
 * @author Angel Balderas
 */
public class CarritoTest {
    
    public CarritoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addProducto method, of class Carrito.
     */
    @Test
    public void testAddProducto() {
        System.out.println("addProducto");
        Publicacion producto = new Publicacion("Coca",32d,"No retornable");
        int cantidad = 1;
        Carrito instance = new Carrito();
        instance.addProducto(producto, cantidad);
        fail("Producto no añadino");
    }

    /**
     * Test of deleteProducto method, of class Carrito.
     */
    @Test
    public void testDeleteProducto() {
        System.out.println("deleteProducto");
        int index = -1;
        Carrito instance = new Carrito();
        instance.deleteProducto(index);
        fail("Producto no borrado");
    }

    /**
     * Test of calcularPrecioTotal method, of class Carrito.
     */
    @Test
    public void testCalcularPrecioTotal() {
        System.out.println("calcularPrecioTotal");
        Carrito instance = new Carrito();
        instance.calcularPrecioTotal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularCambio method, of class Carrito.
     */
    @Test
    public void testCalcularCambio() {
        System.out.println("calcularCambio");
        double pago = 0.0;
        Carrito instance = new Carrito();
        instance.calcularCambio(pago);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarLista method, of class Carrito.
     */
    @Test
    public void testLimpiarLista() {
        System.out.println("limpiarLista");
        Carrito instance = new Carrito();
        instance.limpiarLista();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaProductos method, of class Carrito.
     */
    @Test
    public void testGetListaProductos() {
        System.out.println("getListaProductos");
        Carrito instance = new Carrito();
        ArrayList<Publicacion> expResult = null;
        ArrayList<Publicacion> result = instance.getListaProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidades method, of class Carrito.
     */
    @Test
    public void testGetCantidades() {
        System.out.println("getCantidades");
        Carrito instance = new Carrito();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getCantidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioTotal method, of class Carrito.
     */
    @Test
    public void testGetPrecioTotal() {
        System.out.println("getPrecioTotal");
        Carrito instance = new Carrito();
        double expResult = 0.0;
        double result = instance.getPrecioTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCambio method, of class Carrito.
     */
    @Test
    public void testGetCambio() {
        System.out.println("getCambio");
        Carrito instance = new Carrito();
        double expResult = 0.0;
        double result = instance.getCambio();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPago method, of class Carrito.
     */
    @Test
    public void testGetPago() {
        System.out.println("getPago");
        Carrito instance = new Carrito();
        double expResult = 0.0;
        double result = instance.getPago();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
