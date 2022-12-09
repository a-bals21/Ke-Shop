/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import tnt.almacen.GestorInventario;
import tnt.publicacion.Publicacion;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class EDCajeroController implements Initializable {

    private GestorInventario inventario;
    private CajeroController controlador;
    @FXML
    private TableView<Publicacion> tvwResultados;
    @FXML
    private Button btnAgregar;
    @FXML
    private TextField tfBuscador;
    @FXML
    private TextField tfCantidad;
    @FXML
    private TableColumn<?, ?> colCodigo;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colDescripcion;

    public void iniciar(GestorInventario inventario, CajeroController controlador) {
        this.inventario = inventario;
        this.controlador = controlador;
    }

    public void msgNoSeleccion() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Debe seleccionar algo primero");
        alerta.show();
    }
    
    public void msgSoloEnteros() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("La cantidad debe ser un número entero");
        alerta.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("name"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
    }

    @FXML
    private void buscar(KeyEvent event) {
        String palabra = this.tfBuscador.getText();
        ArrayList<Publicacion> productos = inventario.inventarioPublicacion.obtenerInventario();
        ObservableList<Publicacion> ol = FXCollections.observableArrayList();
        
        for (Publicacion temp: productos) {
            if (temp.getCodigo().toUpperCase().contains(palabra.toUpperCase())
                    || (temp.getName().toUpperCase().contains(palabra.toUpperCase()))) {
                ol.add(temp);
            }
        }

        tvwResultados.setItems(ol);
    }

    @FXML
    private void agregar(ActionEvent event) {
        Publicacion producto = tvwResultados.getSelectionModel().getSelectedItem();
        
        try {
            int cantidad = Integer.parseInt(this.tfCantidad.getText());
            
            producto.setCantidad(cantidad);
            
            if (producto != null) {
                controlador.addProducto(producto);
                
                Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
                
                myStage.close();
            } else {
                msgNoSeleccion();
            }
        } catch (NumberFormatException nfe) {
            msgSoloEnteros();
        }
    }

}
