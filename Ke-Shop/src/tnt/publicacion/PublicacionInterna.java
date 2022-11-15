/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.publicacion;

/**
 * Representa los productos interno o por defecto que ofrece la tienda
 * @author Erika Aguilar
 */
public class PublicacionInterna extends Publicacion {
    private String codigo;

    public PublicacionInterna(String codigo, String nombre, double precio, String descripción) {
        super(nombre, precio, descripción);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
