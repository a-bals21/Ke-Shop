/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.publicacion;

import java.io.Serializable;

/**
 * Representa los producto externo o ajenos a la tienda misma
 * @author Erika Aguilar
 */
public class PublicacionExterna extends Publicacion implements Serializable {
    
    private String telefono;
    private String claveElector;
    
    public PublicacionExterna(String name, double precio, String codigo, String descripcion, String telefono, String claveElector) {
        super(name, precio, codigo, descripcion);
        this.telefono = telefono;
        this.claveElector = claveElector;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClaveElector() {
        return claveElector;
    }

    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }
    
}
