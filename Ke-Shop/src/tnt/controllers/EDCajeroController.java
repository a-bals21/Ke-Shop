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
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import tnt.almacen.GestorInventario;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class EDCajeroController implements Initializable {
    
    private int index = -1;
    private GestorInventario inventario;
    private CajeroController controlador;
    @FXML
    private TableView<?> tvwResultados;
    @FXML
    private Button btnAgregar;
    @FXML
    private TextField tfBuscador;
    @FXML
    private TextField tfCantidad;
    
    public void iniciar(GestorInventario inventario, CajeroController controlador) {
        this.inventario = inventario;
        this.controlador = controlador;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscar(KeyEvent event) {
    }


    @FXML
    private void agregar(ActionEvent event) {
    }
    
}
