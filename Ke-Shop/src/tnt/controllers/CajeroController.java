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
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import tnt.almacen.GestorInventario;
import tnt.cajero.Cajero;
import tnt.perfil.Perfil;
import tnt.publicacion.Publicacion;

/**
 * FXML Controller class
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
    private TableColumn<Publicacion, String>colPrecioT;
    @FXML
    private Button btnEliminarProducto;

    public void setUsuario(Perfil perfil) {
        lNombreUsuario.setText(perfil.getName());

        Date fecha = new Date();

        lFecha.setText(new Date().toLocaleString().substring(0, 12));
    }

    public void setInventario(GestorInventario inventario) {
        this.inventario = inventario;

        cajero = new Cajero(inventario);
        
        actualizarTabla();
    }
    
    public void actualizarTabla() {
        ArrayList<Publicacion> productos = cajero.obtenerCarrito();
        ObservableList<Publicacion> olProductos = FXCollections.observableArrayList();
                
        productos.add(new Publicacion("Coca cola", 23d, "242424", "Coca"));
        productos.get(0).setCantidad(1);

        for (Publicacion temp : productos) {
            olProductos.add(temp);
        }

        tvwCarrito.setItems(olProductos);
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
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Confirmar venta");
        alerta.setHeaderText("¿Realmente quiere cerrar la venta?");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {

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
            stage.setTitle("Nuevo Cajero");

            stage.show();

            controlador.iniciar(inventario, this);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @FXML
    private void registrarProductoExterno(ActionEvent event) {

    }

    @FXML
    private void cerrarCaja(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Confirmar cierre");
        alerta.setHeaderText("¿Realmente quiere cerrar la caja?\nSe le mostrará el total de lo vendido hoy");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {
            
        }
    }

    @FXML
    private void setPago(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Confirmar eliminación");
        alerta.setHeaderText("¿Realmente quiere eliminar el producto seleccionado?");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {
            
        }
    }

}
