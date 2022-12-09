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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tnt.almacen.GestorInventario;
import tnt.publicacion.PublicacionExterna;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class EDPublicacionEController implements Initializable {

    private GestorInventario inventario;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextField tfPrecio;
    @FXML
    private TextField tfClaveElector;
    @FXML
    private TextField tfTelefono;
    @FXML
    private Button btnIngresar;

    public void iniciar(GestorInventario inventario) {
        this.inventario = inventario;
    }

    private void msgVacío() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("No puedes dejar vacío un campo (excepto descripción)");
        alerta.show();
    }

    private void msgYaRegistro() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Producto ya registrado");
        alerta.show();
    }

    private void msgSoloNumeros() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("En precio solo pueden ir números/precios");
        alerta.show();
    }

    private void msgAgregado() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("REGISTRADO");
        alerta.setHeaderText("El producto ha sido registrado");
        alerta.show();
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
        try {
            String name = this.tfNombre.getText().strip();
            String codigo = this.tfCodigo.getText().replaceAll("^//s*", "");
            String descripcion = this.taDescripcion.getText().strip();
            double precio = Double.parseDouble(this.tfPrecio.getText());
            String claveElector = this.tfClaveElector.getText();
            String telefono = this.tfTelefono.getText();

            PublicacionExterna producto = new PublicacionExterna(name, precio, codigo, descripcion, telefono, claveElector);

            if (!(inventario.inventarioPublicacion.contiene(producto))) {
                if (!(name.isBlank() || codigo.isBlank() || claveElector.isEmpty() || telefono.isEmpty())) {
                    inventario.inventarioPublicacion.crear(producto);

                    Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                    myStage.close();

                    msgAgregado();
                    
                    inventario.inventarioPublicacion.guardarInvetario();
                } else {
                    msgVacío();
                }
            } else {
                msgYaRegistro();
            }
        } catch (NumberFormatException nfe) {
            msgSoloNumeros();
        }
    }

}
