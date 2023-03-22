/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.perfil;

import java.io.Serializable;

/**
 * Perfil orientado al Administrador del sistema
 * @author Angel Balderas
 */
public class Administrador extends Perfil implements Serializable {

    public Administrador(String name, String user, String password) {
        super(name, user, password);
    }
    
}
