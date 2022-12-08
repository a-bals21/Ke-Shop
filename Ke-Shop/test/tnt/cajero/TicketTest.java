/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tnt.cajero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import tnt.perfil.Perfil;
import tnt.publicacion.Publicacion;
import tnt.publicacion.PublicacionInterna;

/**
 *
 * @author Angel Balderas
 */
public class TicketTest {
    
    public TicketTest() {
    }

    @Test
    public void testColocarContenido() {
        System.out.println("colocarContenido");
        ArrayList<Publicacion> productos = new ArrayList<>();
        productos.add(new PublicacionInterna("Coca cola", 32d, "232323", "Retornable"));
        productos.add(new PublicacionInterna("Cheetos", 12d, "232324", "Flamin Hot"));
        
        productos.get(1).setCantidad(3);
        
        double sumaT = 0.0;
        
        for(Publicacion temp: productos) {
            sumaT += temp.getCantidad() * temp.getPrecio();
        }
        
        Perfil perfil = new tnt.perfil.Cajero("Angel Balderas", "abals-21", "201980");
        
        
        Ticket instance = new Ticket();
        instance.colocarContenido(productos, sumaT, perfil);
        
        try {
            System.out.println(instance.getContenido());
            instance.generarTicket();
        } catch (IOException ex) {
            Logger.getLogger(TicketTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGenerarTicket() throws Exception {
        System.out.println("generarTicket");
        Ticket instance = new Ticket();
        instance.generarTicket();
        fail("The test case is a prototype.");
    }
    
}
