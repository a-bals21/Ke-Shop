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
    Token tocken;

    public Cajero(CajaRegistradora caja, Carrito carro, Ticket ticket, Token tocken) {
        this.caja = caja;
        this.carro = carro;
        this.ticket = ticket;
        this.tocken = tocken;
    }
    
    
}
