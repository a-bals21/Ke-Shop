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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Lanzador de la interfaz gráfica para controlar el Software
 * @author Angel Balderas
 */
public class Main extends Application {
    Parent root = null;
    Scene escena = null;
    
    //Se ejecuta al intanciarse la escena (Configuración inicial)
    @Override
    public void init() {
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            root = cargarFXML("/tnt/gui/Login.fxml");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        escena = new Scene(root);

        primaryStage.setScene(escena);
        primaryStage.setTitle("Ke-Shop");
        primaryStage.show();
    }
    
    //Al cerrar la aplicación (Para terminar procesos)
    @Override
    public void stop() {
        System.out.println("Cerrando Programa");
    }
    
    public Parent cargarFXML(String path) throws IOException {
        Parent newRoot = null;
        
        newRoot = FXMLLoader.load(getClass().getResource(path));
        
        return newRoot;
    }
    
    public void cerrarPrograma(Node nodo) {
        Stage stg = (Stage) nodo.getScene().getWindow();
        
        stg.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
