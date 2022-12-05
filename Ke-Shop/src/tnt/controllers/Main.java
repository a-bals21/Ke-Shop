/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tnt.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tnt.almacen.GestorInventario;

/**
 * Lanzador de la interfaz gráfica para controlar el Software
 * @author Angel Balderas
 */
public class Main extends Application {
    Parent root = null;
    Scene escena = null;
    GestorInventario inventario;
    
    //Se ejecuta al intanciarse la escena (Configuración inicial)
    @Override
    public void init() {
        inventario = new GestorInventario("./persistencia");
        inventario.cargarInventario();
    }
    
    /**
     * Inicia la escena principal, el Login
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/Login.fxml"));
            root = loader.load();
            LoginController controlador = loader.getController();

            escena = new Scene(root);

            primaryStage.setScene(escena);
            primaryStage.setTitle("Ke-Shop");
            primaryStage.setMaximized(true);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
            
            controlador.setInventario(inventario);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Al cerrar la aplicación (Para terminar procesos)
    @Override
    public void stop() {
        System.out.println("Cerrando Programa");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
