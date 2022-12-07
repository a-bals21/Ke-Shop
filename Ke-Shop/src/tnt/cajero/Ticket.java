/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import tnt.perfil.Perfil;
import tnt.publicacion.Publicacion;

/**
 *  Abstraccion del ticket generado por una compra
 * @author Angel Balderas
 */
public class Ticket {
    private final String infoLocal = "";
    private String contenido;
    
    public void colocarContenido(ArrayList<Publicacion> productos, double suma, Perfil perfil) {
        
    }
    
    public void generarTicket() throws IOException {
        String ruta = "./assets/tickets";
        
        File ticket = new File(ruta);
        
        if(ticket.exists()) {
            ticket.delete();
            
            FileWriter fw = new FileWriter(ticket);
            BufferedWriter bw = new BufferedWriter(fw);
            
            fw.write(contenido);
        } else {
            FileWriter fw = new FileWriter(ticket);
            BufferedWriter bw = new BufferedWriter(fw);
            
            fw.write(contenido);
        }
    }
}
