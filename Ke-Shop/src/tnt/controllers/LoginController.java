/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class LoginController implements Initializable {
    @FXML
    private Button btnSalir;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void clickSalir(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        
        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Desea salir?");
        
        alerta.showAndWait();
        if(alerta.getResult().equals(ButtonType.OK)) {
            System.out.println("I'm tired");
        }
    }
    
}
