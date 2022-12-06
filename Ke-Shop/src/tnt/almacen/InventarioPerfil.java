/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.almacen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import tnt.perfil.Administrador;
import tnt.perfil.Cajero;
import tnt.perfil.Cliente;
import tnt.perfil.Perfil;

/**
 *
 * @author Angel Balderas
 */
public class InventarioPerfil {

    private static ArrayList<Perfil> lista;
    private String rutaGuardado;

    public InventarioPerfil(String rutaGuardado) {
        lista = new ArrayList<>();
        this.rutaGuardado = rutaGuardado;
    }

    public void cargarInventario() {
        String ruta = rutaGuardado + "/perfiles";

        File perfiles = new File(ruta);

        try {
            if (perfiles.exists()) {
                FileInputStream fis = new FileInputStream(ruta);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Object temp = null;

                while ((temp = ois.readObject()) != null) {
                    if (temp.getClass().equals(Administrador.class)) {
                        lista.add((Administrador) temp);
                    } else if (temp.getClass().equals(Cajero.class)) {
                        lista.add((Cajero) temp);
                    }
                }

                System.out.println("Perfiles cargados");
            } else {
                perfiles.createNewFile();

                FileOutputStream fos = new FileOutputStream(ruta, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                Administrador admin = new Administrador("Administrador", "admin-user", "201980");

                oos.writeObject(admin);
                lista.add(admin);

                System.out.println("Perfiles creados y Administrador creado");
            }
        } catch (IOException | ClassNotFoundException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
    
    /**
     * Guarda la lista actual en forma de archivo persistente, actualizando el archivo ya creado
     */
    public void guardarInvetario() {
        String ruta = rutaGuardado + "/perfiles";
        
        File perfiles = new File(ruta);
        perfiles.delete();
        
        try {
            FileOutputStream fos = new FileOutputStream(ruta, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            
            for (Perfil temp: lista) {
                oos.writeObject(temp);
            }

            System.out.println("Perfiles guardados");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void crear(Perfil perfil) {
        lista.add(perfil);
    }

    public Perfil buscar(int index) {
        return lista.get(index);
    }

    public void update(Perfil perfil, int index) {
        lista.set(index, perfil);
    }

    public void borrar(int index) {
        lista.remove(index);
    }

    public boolean contiene(Perfil perfil) {
        boolean value = false;
        
        for (Perfil temp: lista) {
            if (perfil.getUser().equals(temp.getUser())) {
                value = true;
            }
        }
        
        return value;
    }

    public ArrayList<Perfil> obtenerInventario() {
        return lista;
    }

    public void eliminarInventario() {
        lista.clear();
        File perfiles = new File(rutaGuardado + "/perfiles");
        perfiles.delete();
    }
}
