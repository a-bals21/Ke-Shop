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
public class PublicacionExternaTest {
    
    private final PublicacionExterna objTest = new PublicacionExterna(
            "Xbox 360",
            5000d,
            "123456",
            "Seminueva",
            "1112223344",
            "claveelector"
    );
    
    public PublicacionExternaTest() {
    }

    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        PublicacionExterna instance = objTest;
        String expResult = "1112223344";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        PublicacionExterna instance = new PublicacionExterna(
            "Xbox 360",
            5000d,
            "123456",
            "Seminueva",
            "1112223344",
            "claveelector"
        );
        instance.setTelefono(telefono);
        assertEquals("Resultado no esperado", telefono, instance.getTelefono());
    }

    @Test
    public void testGetClaveElector() {
        System.out.println("getClaveElector");
        PublicacionExterna instance = objTest;
        String expResult = "claveelector";
        String result = instance.getClaveElector();
        assertEquals("Resultado no esperado",expResult, result);
    }

    @Test
    public void testSetClaveElector() {
        System.out.println("setClaveElector");
        String claveElector = "";
        PublicacionExterna instance = new PublicacionExterna(
            "Xbox 360",
            5000d,
            "123456",
            "Seminueva",
            "1112223344",
            "claveelector"
        );
        instance.setClaveElector(claveElector);
        assertEquals("Resultado no esperado",claveElector,instance.getClaveElector());
    }
    
}
