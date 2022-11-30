/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.publicacion;

/**
 * Manera de representar los productos dentro del software
 * @author Erika Aguilar
 */
public class Publicacion {
    
    private String name;
    private double precio;
    private String codigo;
    private String descripcion;
    private int cantidad;
        
    public Publicacion(String name, double precio, String codigo, String descripcion) {
        this.name = name;
        this.precio = precio;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
