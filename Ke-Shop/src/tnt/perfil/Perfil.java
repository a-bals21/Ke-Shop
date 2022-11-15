/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.perfil;

/**
 *
 * @author Angel Balderas
 */
public class Perfil {
    private String nombre;
    private String usuario;
    private String contrasenia;

    public Perfil(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public boolean compararContrasenia(String contrasenia) {
        return contrasenia.equals(this.contrasenia);
    }
}
