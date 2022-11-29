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
    private String name;
    private String user;
    private String password;

    public Perfil(String name, String user, String password) {
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String user) {
        this.user = user;
    }

    public String getContrasenia() {
        return password;
    }

    public void setContrasenia(String password) {
        this.password = password;
    }
    
    public boolean compararContrasenia(String password) {
        return password.equals(this.password);
    }
    
}
