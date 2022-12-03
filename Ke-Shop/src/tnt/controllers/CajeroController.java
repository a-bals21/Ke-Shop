/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tnt.almacen.GestorInventario;
import tnt.perfil.Perfil;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CajeroController implements Initializable {
    private GestorInventario inventario;
    @FXML
    private Button btnLogout;
    @FXML
    private TableView<?> tvwCarrito;
    @FXML
    private Button btnVenta;
    @FXML
    private Button btnAddProductoInt;
    @FXML
    private Button btnAddProductoExt;
    @FXML
    private TableColumn<?, ?> tcCodigo;
    @FXML
    private Label lNombreUsuario;
    
    public void setUsuario(Perfil perfil) {
        lNombreUsuario.setText(perfil.getName());
    }
    
    public void setInventario(GestorInventario inventario) {
        this.inventario = inventario;
        inventario.cargarInventario(1);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void desloguear(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        
        alerta.setTitle("Cerrar Sesión");
        alerta.setHeaderText("¿Desea cerrar su sesión?");
        
        alerta.showAndWait();
        if(alerta.getResult().equals(ButtonType.OK)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/Login.fxml"));
                Parent root = loader.load();
                LoginController controlador = loader.getController();

                Scene escena = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(escena);
                stage.setTitle("Ke-Shop");
                stage.setMaximized(true);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();

                Stage myStage = (Stage) this.btnLogout.getScene().getWindow();
                myStage.close();

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void cerrarVenta(ActionEvent event) {
        
    }

    @FXML
    private void addProducto(ActionEvent event) {
        
    }

    @FXML
    private void registrarProductoExterno(ActionEvent event) {
        
    }
    
}
