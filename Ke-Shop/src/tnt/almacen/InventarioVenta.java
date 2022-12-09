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
import tnt.cajero.Venta;

/**
 * Carga y Edita la lista de ventas almacenadas
 * @author Angel Balderas
 */
public class InventarioVenta {
    private static ArrayList<Venta> lista;
    private String rutaGuardado;
    
    public InventarioVenta(String rutaGuardado) {
        lista = new ArrayList<>();
        this.rutaGuardado = rutaGuardado;
    }
    
    /**
     * Carga el inventario, de datos almacenados. Sino existe crea el archivo
     */
    public void cargarInventario() {
        String ruta = rutaGuardado+"/ventas";
        
        File ventas = new File(ruta);
        
        try {
            if(ventas.exists()) {
                FileInputStream fis = new FileInputStream(ruta);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                Object temp;
        
                while ((temp = ois.readObject()) != null) {
                    lista.add((Venta) temp);
                }
                
                System.out.println("Ventas cargadas");
            } else {
               ventas.createNewFile();
               
               System.out.println("Ventas creadas");
            }
        } catch (IOException | ClassNotFoundException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
    
    /**
     * Guarda la lista actual en forma de archivo persistente, actualizando el archivo ya creado
     */
    public void guardarInvetario() {
        String ruta = rutaGuardado + "/ventas";
        
        File ventas = new File(ruta);
        ventas.delete();
        
        try {
            FileOutputStream fos = new FileOutputStream(ruta, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for (Venta temp: lista) {
                oos.writeObject(temp);
            }

            System.out.println("Ventas guardadas");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
    public void crear(Venta venta) {
        lista.add(venta);
    }
    
    /**
     * Busca una venta de la lista de ventas actual y la regresa
     * @param index
     * @return 
     */
    public Venta buscar(int index) {
        return lista.get(index);
    }
    
    /**
     * Actualiza una venta de la lista de ventas actual
     * @param index
     * @param venta 
     */
    public void actualizar(int index, Venta venta) {
        lista.set(index, venta);
    }
    
     /**
      * Elimina una venta de la lista de ventas actual
      * @param index 
      */
    public void borrar(int index) {
        lista.remove(index);
    }
    
    /**
     * Verifica si la lista de ventas actual contiene la venta enviada, y regresa un booleano
     * @param venta
     * @return 
     */
    public boolean contiene(Venta venta) {
        return lista.contains(venta);
    }
    
    /**
     * Regresa la lista de ventas actual
     * @return 
     */
    public ArrayList<Venta> obtenerInventario() {
        return lista;
    }
    
    /**
     * Elimina el inventario, tanto actual como el persistido de perfiles
     */
    public void eliminarInventario() {
        lista.clear();
        File perfiles = new File(rutaGuardado+"/ventas");
        perfiles.delete();
    }
}
