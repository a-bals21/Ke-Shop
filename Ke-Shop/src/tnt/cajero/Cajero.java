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
 *
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

    /**
     * Añade un producto ingresado al carrito
     *
     * @param producto
     */
    public void addProducto(Publicacion producto) {
        carrito.addProducto(producto);
    }

    public void delProducto(Publicacion producto) {
        carrito.eliminarProducto(producto);
    }

    /**
     * Obtiene la suma total del carrito
     *
     * @return
     */
    public double suma() {
        double suma = 0d;
        ArrayList<Publicacion> productos = carrito.getProductos();

        for (Publicacion temp : productos) {
            suma += temp.getCantidad() * temp.getPrecio();
        }

        return suma;
    }

    /**
     * Hace un calculo del cambio
     *
     * @param pago
     * @return
     */
    public double cambio(double pago) {
        double cambio = 0d;

        cambio = pago - suma();

        return cambio;
    }

    /**
     * Finaliza la venta actual, y la guarda en la caja registradora (hasta
     * cerrar caja)
     *
     * @param pago
     */
    public void cerrarVenta(double pago) {
        ArrayList<Publicacion> productos = obtenerCarrito();
        double venta = suma();
        double cambio = cambio(pago);
        Date fecha = new Date();

        if (!productos.isEmpty()) {
            Venta ventaNueva = new Venta(
                    fecha,
                    productos,
                    venta,
                    pago,
                    cambio
            );

            caja.addVenta(ventaNueva);
            
            for (Publicacion temp: ventaNueva.getProductos()) {
                System.out.println(temp.getName());
            }
            
            reiniciarCarro();
        }

    }

    /**
     * Reinicia el carrito a sin productos
     */
    public void reiniciarCarro() {
        carrito.getProductos().clear();
    }

    /**
     * Gusrda las ventas del dia y regresa el total de lo vendido en el día
     *
     * @return
     */
    public double cerrarCaja() {
        double suma = 0d;
        ArrayList<Venta> ventas = caja.getVentasDia();

        if (!ventas.isEmpty()) {
            for (Venta temp : ventas) {
                inventario.inventarioVenta.crear(temp);
                suma += temp.getVenta();
            }

            inventario.inventarioVenta.guardarInvetario();
            caja.vaciarVentasDia();
        }

        return suma;
    }

    /**
     * Regresa el actual carrito de compras
     *
     * @return
     */
    public ArrayList<Publicacion> obtenerCarrito() {
        return carrito.getProductos();
    }
}
