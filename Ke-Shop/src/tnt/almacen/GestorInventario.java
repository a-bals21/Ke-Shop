/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.almacen;

/**
 *
 * @author Angel Balderas
 */
public class GestorInventario {

    public static InventarioPerfil inventarioPerfil;
    public static InventarioPublicacion inventarioPublicacion;
    public static InventarioVenta inventarioVenta;

    public GestorInventario(String ruta) {
        inventarioPerfil = new InventarioPerfil(ruta);
        inventarioPublicacion = new InventarioPublicacion(ruta);
        inventarioVenta = new InventarioVenta(ruta);
    }

    public void cargarInventarios() {
        inventarioPerfil.cargarInventario();
        inventarioPublicacion.cargarInventario();
        inventarioVenta.cargarInventario();
    }

    public void eliminarInventarios() {
        inventarioPerfil.eliminarInventario();
        inventarioPublicacion.eliminarInventario();
        inventarioVenta.eliminarInventario();
    }
    
    public void guardarInventario(int n) {
        switch (n) {
            case 0:
                inventarioPerfil.guardarInvetario();
                break;
            case 1:
                inventarioPublicacion.guardarInvetario();
                break;
            case 2:
                inventarioVenta.guardarInvetario();
                break;
            default:
                break;
        }
    }
}
