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
import tnt.cajero.Venta;

/**
 *
 * @author Angel Balderas
 */
public class InventarioVenta {
    private static ArrayList<Venta> lista;
    private String rutaGuardado;
    
    public InventarioVenta(String rutaGuardado) {
        lista = new ArrayList<>();
        this.rutaGuardado = rutaGuardado;
    }
    
    public void cargarInventario() {
        String ruta = rutaGuardado+"/ventas";
        
        File ventas = new File(ruta);
        
        try {
            if(ventas.exists()) {
                FileInputStream fis = new FileInputStream(ruta);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                Venta temp;
        
                while ((temp = (Venta) ois.readObject()) != null) {
                    lista.add(temp);
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
    
    public void crear(Venta venta) {
        lista.add(venta);
    }
    
    public Venta buscar(int index) {
        return lista.get(index);
    }
    
    public void actualizar(int index, Venta venta) {
        lista.set(index, venta);
    }
    
    public void borrar(int index) {
        lista.remove(index);
    }
    
    public boolean contiene(Venta venta) {
        return lista.contains(venta);
    }
    
    public ArrayList<Venta> obtenerInventario() {
        return lista;
    }
    
    public void eliminarInventario() {
        lista.clear();
        File perfiles = new File(rutaGuardado+"/ventas");
        perfiles.delete();
    }
}
