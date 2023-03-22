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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tnt.almacen.GestorInventario;
import tnt.perfil.Administrador;
import tnt.perfil.Cajero;
import tnt.perfil.Perfil;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class EDPerfilController implements Initializable {

    private int modo;
    private int indexPerfil = -1;
    private AdministracionController controlador;
    private GestorInventario inventario;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btnIngresar;

    public void iniciar(GestorInventario inventario, AdministracionController controlador, int modo) {
        this.inventario = inventario;
        this.controlador = controlador;
        this.modo = modo;
    }

    private void add() {
        String name = this.tfNombre.getText().strip();
        String user = this.tfUsuario.getText().strip();
        String password = this.tfPassword.getText();

        Cajero cajero = new Cajero(name, user, password);

        if (!(inventario.inventarioPerfil.contiene(cajero))) {
            if (!(name.isBlank() || user.isBlank() || password.isBlank())) {
                inventario.inventarioPerfil.crear(cajero);

                Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                myStage.close();

                controlador.actualizarTablaPerfiles();
            } else {
                msgVacío();
            }
        } else {
            msgYaRegistro();
        }
    }

    private void actualizar(int index) {
        String name = this.tfNombre.getText().strip();
        String user = this.tfUsuario.getText().strip();
        String password = this.tfPassword.getText();

        Perfil persona = index != 0 
                ? new Cajero(name, user, password)
                : new Administrador(name, user, password);

        if (!(name.isBlank()
                || user.isBlank()
                || password.isBlank())) {
            inventario.inventarioPerfil.update(persona, index);

            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();

            controlador.actualizarTablaPerfiles();
        } else {
            msgVacío();
        }

    }

    public void setIndexPerfil(Perfil perfil, int index) {
        this.indexPerfil = index;
        
        String name = perfil.getName();
        String user = perfil.getUser();
        String password = perfil.getPassword();

        this.tfNombre.setText(name);
        this.tfUsuario.setText(user);
        this.tfPassword.setText(password);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enviarDatos(ActionEvent event) {
        switch (modo) {
            case 0:
                add();
                break;
            case 1:
                actualizar(indexPerfil);
                break;
            default:
                Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                myStage.close();
                break;
        }
    }

    private void msgVacío() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("No puedes dejar vacío un campo");
        alerta.show();
    }

    private void msgYaRegistro() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Cajero ya registrado");
        alerta.show();
    }
}
