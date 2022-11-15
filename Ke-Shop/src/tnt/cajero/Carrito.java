/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

import java.util.ArrayList;
import tnt.publicacion.*;

/**
 * Encargado de almacenar una lista temporal de productos
 * @author Angel Balderas
 */
public class Carrito {
    private ArrayList<Publicacion> listaProductos = new ArrayList<>();
    private ArrayList<Integer> cantidades = new ArrayList<>();
    private double precioTotal = 0;
    private double cambio = 0;
    private double pago = 0;
    
    /**
     * Añadir un producto y su cantidad al carrito
     * @param producto
     * @param cantidad 
     */
    public void addProducto(Publicacion producto, int cantidad) {
        listaProductos.add(producto);
        cantidades.add(cantidad);
        
    }
    
    /**
     * Borrar productos de la lista
     * @param index 
     */
    public void deleteProducto(int index) {
        listaProductos.remove(index);
        cantidades.remove(index);
    }
    
    /**
     * Calcula el precio total de los productos del carrito
     */
    public void calcularPrecioTotal() {
        int suma = 0;
        
        for (int i = 0; i<listaProductos.size(); i++ ) {
            suma += listaProductos.get(i).getPrecio();
        }
        
        precioTotal = suma;
    }
    
    /**
     * Calcula el cambio dependiendo del pago ingresado
     * @param pago 
     */
    public void calcularCambio(double pago) {
        this.pago = pago;
        cambio = pago - precioTotal;
    }
    
    /**
     * Llamar para iniciar otro carrito; Limpia todos los elementos del carrito actual
     */
    public void limpiarLista() {
        listaProductos.clear();
        cantidades.clear();
    }
    
    /**
     * Regresa la actual lista de productos del carrito
     * @return listaProductos
     */
    public ArrayList<Publicacion> getListaProductos() {
        return listaProductos;
    }
    
    /**
     * Regresa la actual lista de cantidades vendidas por producto del carrito
     * @return cantidades
     */
    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }
    
    /**
     * Regresa el precio total del carrito
     * @return precio
     */
    public double getPrecioTotal() {
        return precioTotal;
    }
    
    /**
     * Regresa el cambio generado
     * @return cambio
     */
    public double getCambio() {
        return cambio;
    }
    
    /**
     * Regresa la cantidad pagada
     * @return pago
     */
    public double getPago() {
        return pago;
    }
    
    
}
