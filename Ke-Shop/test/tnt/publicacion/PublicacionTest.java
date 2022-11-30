/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tnt.publicacion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel Balderas
 */
public class PublicacionTest {
    
    private final Publicacion objTest = new Publicacion("Coca",29d,"242424","No retornable");
    
    public PublicacionTest() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Publicacion instance = objTest;
        String expResult = "Coca";
        String result = instance.getName();
        assertEquals("Resultado no esperado",expResult, result);
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Publicacion instance = new Publicacion("",0d,"","");
        instance.setName(name);
        assertEquals("Resultado no esperado",name, instance.getName());
    }

    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Publicacion instance = objTest;
        double expResult = 29d;
        double result = instance.getPrecio();
        assertEquals("Resultado no esperado",expResult, result, 0);
    }

    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 27.0;
        Publicacion instance = new Publicacion("",0d,"","");
        instance.setPrecio(precio);
        assertEquals("Resultado no esperado",precio, instance.getPrecio(), 0);
    }

    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Publicacion instance = objTest;
        String expResult = "242424";
        String result = instance.getCodigo();
        assertEquals("Resultado no esperado",expResult, result);
    }

    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "";
        Publicacion instance = new Publicacion("",0d,"","");
        instance.setCodigo(codigo);
        assertEquals("Resultado no esperado",codigo, instance.getCodigo());
    }

    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Publicacion instance = objTest;
        String expResult = "No retornable";
        String result = instance.getDescripcion();
        assertEquals("Resultado no esperado",expResult, result);
    }

    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Publicacion instance = new Publicacion("",0d,"","");
        instance.setDescripcion(descripcion);
        assertEquals("Resultado no esperado",descripcion, instance.getDescripcion());
    }

    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Publicacion instance = objTest;
        int expResult = 0;
        int result = instance.getCantidad();
        assertEquals("Resultado no esperado",expResult, result);
    }

    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        Publicacion instance = new Publicacion("",0d,"","");
        instance.setCantidad(cantidad);
        assertEquals("Resultado no esperado",cantidad, instance.getCantidad(), 0);
    }
    
}
