/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.publicacion;

/**
 * Representa los producto externo o ajenos a la tienda misma
 * @author Erika Aguilar
 */
public class PublicacionExterna extends Publicacion {
    private String token;
    private String nomCliente;
    private String telCliente;
    private String claveElectorCliente;

    public PublicacionExterna(String token, String nomCliente, String telCliente, String claveElectorCliente, String nombre, double precio, String descripción) {
        super(nombre, precio, descripción);
        this.token = token;
        this.nomCliente = nomCliente;
        this.telCliente = telCliente;
        this.claveElectorCliente = claveElectorCliente;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public String getClaveElectorCliente() {
        return claveElectorCliente;
    }

    public void setClaveElectorCliente(String claveElectorCliente) {
        this.claveElectorCliente = claveElectorCliente;
    }
    
    
    
}
