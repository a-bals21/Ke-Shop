/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

import java.util.ArrayList;

/**
 * Encargado de guardar el registro de ventas
 * @author Angel Balderas
 */
public class CajaRegistradora {
    private ArrayList<Venta> ventasDia;

    public CajaRegistradora(){
        ventasDia = new ArrayList<>();
    }
    
    public void addVenta(Venta venta){
        ventasDia.add(venta);
    }
    
    public ArrayList<Venta> getVentasDia() {
        return ventasDia;
    }
    
    public void vaciarVentasDia() {
        ventasDia.clear();
    }
}
