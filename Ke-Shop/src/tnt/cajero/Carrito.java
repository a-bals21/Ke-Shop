/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

import java.util.ArrayList;
import tnt.publicacion.Publicacion;

/**
 * Encargado de almacenar una lista temporal de productos
 * @author Angel Balderas
 */
public class Carrito {
    private ArrayList<Publicacion> productos;

    public Carrito(ArrayList<Publicacion> productos) {
        this.productos = productos;
    }
    
    public void addProducto(Publicacion publicacion) {
        productos.add(publicacion);
    }
    
    public void eliminarProducto(int index) {
        productos.remove(index);
    }
    
    public void eliminarProducto(Publicacion publicacion) {
        productos.remove(publicacion);
    }
    
    public double sumaProductos() {
        double suma = 0;
        
        for (Publicacion temp: productos) {
            suma += (temp.getCantidad()*temp.getPrecio());
        }
        return suma;
    }
    
    public ArrayList<Publicacion> getProductos() {
        return productos;
    }
    
    public void vaciarCarrito() {
        productos.clear();
    }
}
