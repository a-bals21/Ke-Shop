/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import tnt.publicacion.Publicacion;

/**
 *  Abstracción de la venta generada al cerrar una compra del cajero
 * @author Angel Balderas
 */
public class Venta implements Serializable {
    private Date fecha;
    private ArrayList<Publicacion> productos;
    private double venta;
    private double pago;
    private double cambio;

    public Venta(Date fecha, ArrayList<Publicacion> productos, double venta, double pago, double cambio) {
        this.fecha = fecha;
        this.productos = productos;
        this.venta = venta;
        this.pago = pago;
        this.cambio = cambio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Publicacion> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Publicacion> productos) {
        this.productos = productos;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
    
    
}
