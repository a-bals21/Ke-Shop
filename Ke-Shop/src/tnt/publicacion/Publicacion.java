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
    private String nombre;
    private double precio;
    private String descripcion;

    public Publicacion(String nombre, double precio, String descripción) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripción;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripción() {
        return descripcion;
    }

    public void setDescripción(String descripción) {
        this.descripcion = descripción;
    }
    
    
}
