/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.cajero;

/**
 * Gestiona las funciones de un cajero
 * @author Angel Balderas
 */
public class Cajero {
    CajaRegistradora caja;
    Carrito carro;
    Ticket ticket;

    public Cajero(CajaRegistradora caja, Carrito carro, Ticket ticket) {
        this.caja = caja;
        this.carro = carro;
        this.ticket = ticket;
    }
    
    
}
