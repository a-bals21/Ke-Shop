/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tnt.almacen.GestorInventario;
import tnt.cajero.Cajero;
import tnt.perfil.Perfil;
import tnt.publicacion.Publicacion;

/**
 * Controla el acceso al modo cajero
 *
 * @author Angel Balderas
 */
public class CajeroController implements Initializable {

    private GestorInventario inventario;
    private Cajero cajero;
    private double pago = 0;
    @FXML
    private Button btnLogout;
    @FXML
    private TableView<Publicacion> tvwCarrito;
    @FXML
    private Button btnAddProductoInt;
    @FXML
    private Label lNombreUsuario;
    @FXML
    private Button btnCerrarCaja;
    @FXML
    private Button btnRegProductoExt;
    @FXML
    private Button btnCerrarVenta;
    @FXML
    private Label lFecha;
    @FXML
    private Label lPago;
    @FXML
    private Label lTotal;
    @FXML
    private Label lCambio;
    @FXML
    private Button btnInsertarPago;
    @FXML
    private TableColumn<?, ?> colCodigo;
    @FXML
    private TableColumn<?, ?> colProducto;
    @FXML
    private TableColumn<?, ?> colPrecioU;
    @FXML
    private TableColumn<?, ?> colCantidad;
    @FXML
    private TableColumn<Publicacion, String> colPrecioT;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TextField tfPago;

    public void setUsuario(Perfil perfil) {
        lNombreUsuario.setText(perfil.getName());

        Date fecha = new Date();

        lFecha.setText(new Date().toLocaleString().substring(0, 12));
    }

    public void setInventario(GestorInventario inventario) {
        this.inventario = inventario;

        cajero = new Cajero(inventario);
    }

    public void actualizarTabla() {
        ArrayList<Publicacion> productos = cajero.obtenerCarrito();
        ObservableList<Publicacion> olProductos = FXCollections.observableArrayList();

        for (Publicacion temp : productos) {
            olProductos.add(temp);
        }

        tvwCarrito.setItems(olProductos);
        lTotal.setText(String.valueOf(cajero.suma()));
        lCambio.setText(String.valueOf(cajero.cambio(pago)));
    }

    public void addProducto(Publicacion producto) {
        cajero.addProducto(producto);

        actualizarTabla();
    }

    public void msgNoSeleccion() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Debe seleccionar algo primero");
        alerta.show();
    }

    public void msgSoloNumeros() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Debe ingresar solo números en pago");
        alerta.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.colProducto.setCellValueFactory(new PropertyValueFactory("name"));
        this.colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colPrecioU.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colPrecioT.setCellValueFactory((CellDataFeatures<Publicacion, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getPrecio() * p.getValue().getCantidad()));
    }

    @FXML
    private void desloguear(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Cerrar Sesión");
        alerta.setHeaderText("¿Desea cerrar su sesión?");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {
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
        if (pago != 0) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

            alerta.setTitle("Confirmar venta");
            alerta.setHeaderText("¿Realmente quiere cerrar la venta?");

            alerta.showAndWait();
            if (alerta.getResult().equals(ButtonType.OK)) {
                this.pago = 0d;
                this.lPago.setText("0000.00");
                this.lCambio.setText("0000.00");

                cajero.cerrarVenta(pago);

                actualizarTabla();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("ADVERTENCIA");
            alerta.setHeaderText("Debe insertar el pago");
            alerta.show();
        }
    }

    @FXML
    private void addProducto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/EDCajero.fxml"));
            Parent root = loader.load();
            EDCajeroController controlador = loader.getController();

            Scene escena = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(escena);
            stage.setTitle("Buscador Prod.");

            stage.show();

            controlador.iniciar(inventario, this);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @FXML
    private void registrarProductoExterno(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/EDPublicacionE.fxml"));
            Parent root = loader.load();
            EDPublicacionEController controlador = loader.getController();

            Scene escena = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(escena);
            stage.setTitle("Registro Prod. Ext.");

            stage.show();

            controlador.iniciar(inventario);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @FXML
    private void cerrarCaja(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Confirmar cierre");
        alerta.setHeaderText("¿Realmente quiere cerrar la caja?\nSe le mostrará el total de lo vendido hoy");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {
            Alert cierre = new Alert(Alert.AlertType.CONFIRMATION);

            cierre.setTitle("Caja cerrada");
            cierre.setHeaderText("Hoy se vendió un total de " + String.valueOf(cajero.cerrarCaja() + "\nLas ventas se han almacenado"));

            this.pago = 0d;
            this.lPago.setText("0000.00");
            this.lCambio.setText("0000.00");

            cierre.showAndWait();

            cajero.cerrarCaja();

            actualizarTabla();
        }
    }

    @FXML
    private void setPago(ActionEvent event) {
        try {
            this.pago = Double.parseDouble(this.tfPago.getText());
            lPago.setText(String.valueOf(this.pago));

            actualizarTabla();

            tfPago.setText("");
        } catch (NumberFormatException nfe) {
            msgSoloNumeros();
        }
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        Publicacion producto = tvwCarrito.getSelectionModel().getSelectedItem();

        if (producto != null) {
            alerta.setTitle("Confirmar eliminación");
            alerta.setHeaderText("¿Realmente quiere eliminar el producto seleccionado?");

            alerta.showAndWait();
            if (alerta.getResult().equals(ButtonType.OK)) {
                cajero.delProducto(producto);

                actualizarTabla();
            }
        } else {
            msgNoSeleccion();
        }
    }

}
