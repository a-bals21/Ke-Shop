/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.perfil;

import java.io.Serializable;

/**
 *
 * @author Angel Balderas
 */
public class Cliente extends Perfil implements Serializable{

    public Cliente(String name, String user, String password) {
        super(name, user, password);
    }
    
}
