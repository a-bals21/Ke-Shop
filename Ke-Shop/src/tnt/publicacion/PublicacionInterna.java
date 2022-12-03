/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.publicacion;

import java.io.Serializable;

/**
 * Representa los productos interno o por defecto que ofrece la tienda
 * @author Erika Aguilar
 */
public class PublicacionInterna extends Publicacion implements Serializable {
    
    public PublicacionInterna(String name, double precio, String codigo, String descripcion) {
        super(name, precio, codigo, descripcion);
    }
    
}
