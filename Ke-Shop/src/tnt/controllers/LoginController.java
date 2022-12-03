/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tnt.almacen.GestorInventario;
import tnt.perfil.Perfil;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class LoginController implements Initializable {
    
    private GestorInventario inventario;
    @FXML
    private Button btnSalir;
    @FXML
    private BorderPane bpBacon;
    @FXML
    private TextField txtfUser;
    @FXML
    private Button btnIngresar;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Label lError;
    
    public void setInventario(GestorInventario inventario) {
        this.inventario = inventario;
    }
    
    public void cambiarEscena(Perfil perfil){
        try {
            FXMLLoader loader = null;
            
            if (perfil.getClass().equals(tnt.perfil.Cajero.class)) {
                loader = new FXMLLoader(getClass().getResource("/tnt/gui/Cajero.fxml"));
                Parent root = loader.load();

                Scene escena = new Scene(root);
                Stage stage = new Stage();
                
                CajeroController controlador = loader.getController();

                stage.setScene(escena);
                stage.setTitle("Ke-Shop");
                stage.setMaximized(true);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                
                controlador.setUsuario(perfil);
                controlador.setInventario(inventario);
            } else if (perfil.getClass().equals(tnt.perfil.Administrador.class)) {
                loader = new FXMLLoader(getClass().getResource("/tnt/gui/Administracion.fxml"));
                Parent root = loader.load();

                Scene escena = new Scene(root);
                Stage stage = new Stage();
                
                AdministracionController controlador = loader.getController();

                stage.setScene(escena);
                stage.setTitle("Ke-Shop");
                stage.setMaximized(true);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                
                controlador.setUsuario(perfil);
                controlador.setInventario(inventario);
            } else if (perfil.getClass().equals(tnt.perfil.Cliente.class)) {
                loader = new FXMLLoader(getClass().getResource("/tnt/gui/Cliente.fxml"));
                Parent root = loader.load();

                Scene escena = new Scene(root);
                Stage stage = new Stage();
                
                AdministracionController controlador = loader.getController();

                stage.setScene(escena);
                stage.setTitle("Ke-Shop");
                stage.setMaximized(true);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            }
            
            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Perfil obtenerPerfil(String user, String password) {
        Perfil perfil = null;
        ArrayList<Perfil> perfiles = inventario.inventarioPerfil.obtenerInventario();
        
        for (Perfil temp: perfiles) {
            if ( (user.equals(temp.getUser())) && (temp.getPassword().equals(password)) ) {
                perfil = temp;
            }
        }
        
        return perfil;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Metodo para cerrar la ventana Login
     * @param event 
     */
    @FXML
    private void clicSalir(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        
        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Desea salir?");
        
        alerta.showAndWait();
        if(alerta.getResult().equals(ButtonType.OK)) {
            Node node = (Node) event.getSource();
            Stage currentStage = (Stage) node.getScene().getWindow();
            currentStage.close();
        }
    }
    
    /**
     * Metodo para abrir el navegador e ir a la página del repositorio del programa
     * @param event 
     */
    @FXML
    private void goToGithub(MouseEvent event) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    URI uri = new URI("https://github.com/a-bals21/Ke-Shop");
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    /**
     * Método para ingresar a la ventana respectiva al perfil
     * @param event 
     */
    @FXML
    private void ingresar(ActionEvent event) {
        Perfil perfil = null;
        
        perfil = obtenerPerfil(txtfUser.getText(), pfPassword.getText());
        
        if (perfil == null) {
            lError.setText("El usuario o la contraseña es incorrecta");
        } else {
            cambiarEscena(perfil);
        }
    }
}