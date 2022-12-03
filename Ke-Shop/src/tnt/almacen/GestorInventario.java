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
    
    public void cargarInventario(int inventario) {
        switch (inventario) {
            case 0: 
                inventarioPerfil.cargarInventario(); break;
            case 1:
                inventarioPublicacion.cargarInventario(); break;
            case 2:
                inventarioVenta.cargarInventario(); break;
            default:
                inventarioPerfil.cargarInventario();
                inventarioPublicacion.cargarInventario();
                inventarioVenta.cargarInventario();
                break;
        }
    }
    
    
    public void eliminarInventario(int inventario){
        switch (inventario) {
            case 0: 
                inventarioPerfil.eliminarInventario(); break;
            case 1:
                inventarioPublicacion.eliminarInventario(); break;
            case 2:
                inventarioVenta.eliminarInventario(); break;
            default:
                inventarioPerfil.eliminarInventario();
                inventarioPublicacion.eliminarInventario();
                inventarioVenta.eliminarInventario();
                break;
        }
    }
}
