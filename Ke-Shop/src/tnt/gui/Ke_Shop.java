/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tnt.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Interfaz Gráfica para controlar el Software
 * @author Erika Aguilar, Angel Balderas, Kevin Camelo
 */
public class Ke_Shop extends Application {
    
    Parent root = null;
    
    //Se ejecuta al intanciarse la escena (Configuración inicial)
    @Override
    public void init() {
        
    }
    
    //Instanciación de componentes gráficos
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("/tnt/gui/InterfazPrincipal.fxml"));
        
        Scene escena = new Scene(root, 800, 460);
        
        primaryStage.setScene(escena);
        primaryStage.setTitle("Ke-Shop");
        primaryStage.show();
    }
    
    //Al cerrar la aplicación (Para terminar procesos)
    @Override
    public void stop() {
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
