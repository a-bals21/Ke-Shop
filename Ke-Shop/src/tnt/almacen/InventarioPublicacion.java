/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.almacen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import tnt.publicacion.Publicacion;
import tnt.publicacion.PublicacionExterna;
import tnt.publicacion.PublicacionInterna;

/**
 *
 * @author Angel Balderas
 */
public class InventarioPublicacion {
    private static ArrayList<Publicacion> lista;
    public String rutaGuardado;
    
    public InventarioPublicacion(String rutaGuardado) {
        lista = new ArrayList<>();
        this.rutaGuardado = rutaGuardado;
    }
    
    public void cargarInventario() {
        String ruta = rutaGuardado+"/publicaciones";
        
        File productos = new File(ruta);
        
        try {
            if(productos.exists()) {
                FileInputStream fis = new FileInputStream(ruta);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                Object temp;
        
                while ((temp = ois.readObject()) != null) {
                    if (temp.getClass().equals(PublicacionInterna.class)) {
                        lista.add((PublicacionInterna) temp);
                    } else if (temp.getClass().equals(PublicacionExterna.class)) {
                        lista.add((PublicacionExterna) temp);
                    }
                }
                
                System.out.println("Productos cargados");
            } else {
               productos.createNewFile();
               
               System.out.println("Productos creados");
            }
        } catch (IOException | ClassNotFoundException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
    
    public void crear(Publicacion publicacion) {
        lista.add(publicacion);
    }
    
    public Publicacion buscar(int index) {
        return lista.get(index);
    }
    
    public void update(Publicacion publicacion, int index) {
        lista.set(index, publicacion);
    }
    
    public void borrar(int index) {
        lista.remove(index);
    }
    
    public boolean contiene(Publicacion publicacion) {
        return lista.contains(publicacion);
    }
    
    public ArrayList<Publicacion> obtenerInventario() {
        return lista;
    }
    
    public void eliminarInventario() {
        lista.clear();
        File perfiles = new File(rutaGuardado+"/publicaciones");
        perfiles.delete();
    }
}
