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
    
    public void colocarContenido(ArrayList<Publicacion> productos, double sumaT, Perfil perfil) {
        contenido = "Ke-shop\nCompra realizada\nCajero "+perfil.getName()+"\n";
        
        for (Publicacion temp: productos) {
            double sumaP = temp.getCantidad() * temp.getPrecio();
            contenido += "\n"+temp.getName()+"\t"+temp.getCantidad()+"\t$"+sumaP;
        }
        
        contenido += "\n\n\tTotal " + sumaT;
    }
    
    public void generarTicket() throws IOException {
        String ruta = "./assets/tickets/ticket.txt";
        
        File ticket = new File(ruta);
        
        if(ticket.exists()) {
            ticket.delete();
            
            generarTicket();
        } else {
            ticket.createNewFile();
            
            FileWriter fw = new FileWriter(ticket);
            BufferedWriter bw = new BufferedWriter(fw);
            
            fw.write(contenido);
        }
    }
    
    public String getContenido() {
        return contenido;
    }
}
