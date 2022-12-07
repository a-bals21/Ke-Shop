/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.almacen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import tnt.publicacion.Publicacion;
import tnt.publicacion.PublicacionExterna;
import tnt.publicacion.PublicacionInterna;

/**
 * Carga y Edita la lista de productos almacenados
 * @author Angel Balderas
 */
public class InventarioPublicacion {
    private static ArrayList<Publicacion> lista;
    public String rutaGuardado;
    
    public InventarioPublicacion(String rutaGuardado) {
        lista = new ArrayList<>();
        this.rutaGuardado = rutaGuardado;
    }
    
    /**
     * Carga el inventario, de datos almacenados. Sino existe crea el archivo
     */
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
    
    /**
     * Guarda la lista de productos actual en forma de archivo persistente, actualizando el archivo ya creado
     */
    public void guardarInvetario() {
        String ruta = rutaGuardado + "/publicaciones";
        
        File perfiles = new File(ruta);
        perfiles.delete();
        
        try {
            FileOutputStream fos = new FileOutputStream(ruta, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            
            for (Publicacion temp: lista) {
                oos.writeObject(temp);
            }

            System.out.println("Productos guardados");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
    /**
     * Añade un producto a la lista de productos actual
     * @param publicacion 
     */
    public void crear(Publicacion publicacion) {
        lista.add(publicacion);
    }
    
    /**
     * Busca un producto de la lista de productos actual y lo regresa
     * @param index
     * @return 
     */
    public Publicacion buscar(int index) {
        return lista.get(index);
    }
    
    /**
     * Actualiza un producto de la lista de productos actual
     * @param publicacion
     * @param index 
     */
    public void update(Publicacion publicacion, int index) {
        lista.set(index, publicacion);
    }
    
    /**
     * Elimina un producto de la lista de productos actual
     * @param index 
     */
    public void borrar(int index) {
        lista.remove(index);
    }
    
    /**
     * Verifica si la lista de productos actual contiene el producto enviado, y regresa un booleano
     * @param publicacion
     * @return 
     */
    public boolean contiene(Publicacion publicacion) {
        boolean value = false;
        
        for (Publicacion temp: lista) {
            if (
                    publicacion.getCodigo().equals(temp.getCodigo()) ||
                    publicacion.getName().equals(temp.getName())
                ) {
                value = true;
            }
        }
        
        return value;
    }
    
    /**
     * Regresa la lista de productos actual
     * @return 
     */
    public ArrayList<Publicacion> obtenerInventario() {
        return lista;
    }
    
    /**
     * Elimina el inventario, tanto actual como el persistido de perfiles
     */
    public void eliminarInventario() {
        lista.clear();
        File perfiles = new File(rutaGuardado+"/publicaciones");
        perfiles.delete();
    }
}
