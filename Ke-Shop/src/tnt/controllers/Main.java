/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package tnt.controllers;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
    public void start(Stage primaryStage) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("/tnt/gui/Login.fxml"));
        escena = new Scene(root);
        
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Ke-Shop");
        primaryStage.show();
    }
    
    //Al cerrar la aplicación (Para terminar procesos)
    @Override
    public void stop() {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
