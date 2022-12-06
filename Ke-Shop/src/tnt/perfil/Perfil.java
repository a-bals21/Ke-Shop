/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.perfil;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Angel Balderas
 */
public class Perfil implements Serializable {
    private String name;
    private String user;
    private String password;

    public Perfil(String name, String user, String password) {
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean compararPassword(String password) {
        return password.equals(this.password);
    }    
}
