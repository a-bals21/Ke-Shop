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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tnt.almacen.GestorInventario;
import tnt.publicacion.Publicacion;
import tnt.publicacion.PublicacionInterna;

/**
 * Controlador para la entrada de productos a la persistencia
 *
 * @author Angel Balderas
 */
public class EDPublicacionController implements Initializable {

    private int indexProducto;
    private int modo = -1;
    private GestorInventario inventario;
    private AdministracionController controlador;
    @FXML
    private Label lError;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextField tfPrecio;
    @FXML
    private Button btnIngresar;

    public void iniciar(GestorInventario inventario, AdministracionController controlador, int modo) {
        this.inventario = inventario;
        this.controlador = controlador;
        this.modo = modo;
    }

    private void add() {
        try {
            String name = this.tfNombre.getText().strip();
            String codigo = this.tfCodigo.getText().replaceAll("^//s*", "");
            String descripcion = this.taDescripcion.getText().strip();
            double precio = Double.parseDouble(this.tfPrecio.getText());

            PublicacionInterna producto = new PublicacionInterna(name, precio, codigo, descripcion);

            if (!(inventario.inventarioPublicacion.contiene(producto))) {
                if (!(name.isBlank() || codigo.isBlank())) {
                    inventario.inventarioPublicacion.crear(producto);

                    Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                    myStage.close();

                    controlador.actualizarTablaProductos();
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

    private void actualizar(int index) {
        try {
            String name = this.tfNombre.getText().strip();
            String codigo = this.tfCodigo.getText().replaceAll("^//s*", "");
            String descripcion = this.taDescripcion.getText().strip();
            double precio = Double.parseDouble(this.tfPrecio.getText());

            PublicacionInterna producto = new PublicacionInterna(name, precio, codigo, descripcion);

            if (!(name.isBlank() || codigo.isBlank())) {
                inventario.inventarioPublicacion.update(producto, index);

                Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                myStage.close();

                controlador.actualizarTablaProductos();
            } else {
                msgVacío();
            }
        } catch (NumberFormatException nfe) {
            msgSoloNumeros();
        }
    }

    public void setIndexProducto(Publicacion producto, int indexProducto) {
        this.indexProducto = indexProducto;

        tfNombre.setText(producto.getName());
        tfCodigo.setText(producto.getCodigo());
        taDescripcion.setText(producto.getDescripcion());
        tfPrecio.setText(String.valueOf(producto.getPrecio()));
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
                actualizar(indexProducto);
                break;
            default:
                Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                myStage.close();
                break;
        }
    }
}
