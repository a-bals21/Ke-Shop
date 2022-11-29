/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tnt.publicacion;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Angel Balderas
 */
public class PublicacionTest {
    
    //private final Publicacion objTest = new Publicacion("Refresco",27,"2121563","No retornable");
    

    /**
     * Test of getName method, of class Publicacion.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Publicacion instance = new Publicacion("Refresco",27,"2121563","No retornable");
        String expResult = "Refresco";
        String result = instance.getName();
        assertEquals("Test getName",expResult, result);
        //fail("Test getName error");
    }

    /**
     * Test of setName method, of class Publicacion.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Publicacion instance = null;
        instance.setName(name);
        //fail("Test setName error");
    }

    /**
     * Test of getPrecio method, of class Publicacion.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Publicacion instance = new Publicacion("Refresco",27,"2121563","No retornable");
        double expResult = 27d;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0);
        //fail("Test getPrecio error");
    }

    /**
     * Test of setPrecio method, of class Publicacion.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 0.0;
        Publicacion instance = null;
        instance.setPrecio(precio);
       // fail("Test setPrecio error");
    }

    /**
     * Test of getCodigo method, of class Publicacion.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Publicacion instance = new Publicacion("Refresco",27,"2121563","No retornable");
        String expResult = "2121563";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        //fail("Test getCodigo error");
    }

    /**
     * Test of setCodigo method, of class Publicacion.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "";
        Publicacion instance = null;
        instance.setCodigo(codigo);
        //fail("Test setCodigo error");
    }

    /**
     * Test of getDescripcion method, of class Publicacion.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Publicacion instance = new Publicacion("Refresco",27,"2121563","No retornable");
        String expResult = "No retornable";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        //fail("Test getDescripcion error");
    }

    /**
     * Test of setDescripcion method, of class Publicacion.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Publicacion instance = null;
        instance.setDescripcion(descripcion);
        //fail("Test setDescripcion error");
    }

    /**
     * Test of getCantidad method, of class Publicacion.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Publicacion instance = new Publicacion("Refresco",27,"2121563","No retornable");
        int expResult = 0;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        //fail("Test getCantidad Error");
    }

    /**
     * Test of setCantidad method, of class Publicacion.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        Publicacion instance = null;
        instance.setCantidad(cantidad);
        //fail("Test setCantidad error");
    }
    
}
