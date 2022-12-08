/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

import java.util.ArrayList;
import java.util.Date;
import tnt.almacen.GestorInventario;
import tnt.publicacion.Publicacion;

/**
 * Gestiona las funciones de un cajero
 * @author Angel Balderas
 */
public class Cajero {
    private Carrito carrito;
    private CajaRegistradora caja;
    private GestorInventario inventario;
    
    public Cajero(GestorInventario inventario) {
        carrito = new Carrito();
        caja = new CajaRegistradora();
        this.inventario = inventario;
    }
    
    public void addProducto(Publicacion producto) {
        carrito.addProducto(producto);
    }
    
    public double suma() {
        double suma = 0d;
        
        for (Publicacion temp: carrito.getProductos()) {
            suma += temp.getCantidad() * temp.getPrecio();
        }
        
        return suma;
    }
    
    public double cambio(double pago) {
        double cambio = 0d;
        
        cambio = pago - suma();
        
        return cambio;
    }
    
    public void cerrarVenta(double pago) {
        Venta venta = new Venta(
                new Date(),
                carrito.getProductos(),
                suma(),
                pago,
                cambio(pago)
        );
        
        caja.addVenta(venta);
        
        reiniciarCarro();
    }
    
    public void reiniciarCarro() {
        carrito.getProductos().clear();
    }
    
    public double cerrarCaja() {
        double suma = 0d;
        
        for (Venta temp: caja.getVentasDia()) {
            inventario.inventarioVenta.crear(temp);
        }
        
        return suma;
    }
    
    public ArrayList<Publicacion> obtenerCarrito() {
        return carrito.getProductos();
    }
}
