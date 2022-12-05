/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tnt.almacen.GestorInventario;
import tnt.cajero.Venta;
import tnt.perfil.Perfil;
import tnt.publicacion.Publicacion;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class AdministracionController implements Initializable {

    GestorInventario inventario;

    @FXML
    private Label lNombreUsuario;
    @FXML
    private Button btnLogout;
    @FXML
    private TableView<Publicacion> tvwProductos;
    @FXML
    private ChoiceBox<String> cbFiltroProducto;
    @FXML
    private TableView<Perfil> tvwPerfiles;
    @FXML
    private TableView<Venta> tvwVentas;
    @FXML
    private TableColumn<?, ?> colNombrePerfil;
    @FXML
    private TableColumn<?, ?> colUsuarioPerfil;
    @FXML
    private TableColumn<?, ?> colCodigoProducto;
    @FXML
    private TableColumn<?, ?> colNombreProducto;
    @FXML
    private TableColumn<?, ?> colPrecioProducto;
    @FXML
    private TableColumn<?, ?> colDescripcionProducto;
    @FXML
    private TableColumn<?, ?> colFechaVenta;
    @FXML
    private TableColumn<?, ?> colProductosVenta;
    @FXML
    private TableColumn<?, ?> colMontoVenta;
    @FXML
    private TableColumn<?, ?> colPagoVenta;
    @FXML
    private TableColumn<?, ?> colCambioVenta;
    @FXML
    private Button btnAddPerfil;
    @FXML
    private Button btnEditarPerfil;
    @FXML
    private Button btnEliminarPerfil;
    @FXML
    private Button btnGuardarCambiosPerfil;
    @FXML
    private TextField tfBuscadorProducto;
    @FXML
    private Button btnBuscarProducto;
    @FXML
    private Button btnAddProducto;
    @FXML
    private Button btnEditarProducto;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private Button btnGuardarCambiosProducto;
    @FXML
    private ChoiceBox<?> cbFiltroVenta;
    @FXML
    private Button btnBuscarVenta;
    @FXML
    private Button btnGuardarCambiosVenta;

    /**
     * Inicia el acceso al inventario
     *
     * @param inventario
     */
    public void setInventario(GestorInventario inventario) {
        this.inventario = inventario;

        cbFiltroProducto.getItems().addAll("Nombre", "Código");
        actualizarTablaPerfiles();
    }

    /**
     * Personaliza el nombre dependiendo del usuario
     *
     * @param perfil
     */
    public void setUsuario(Perfil perfil) {
        lNombreUsuario.setText(perfil.getName());
    }

    public void actualizarTablaPerfiles() {
        ArrayList<Perfil> perfiles = inventario.inventarioPerfil.obtenerInventario();
        ObservableList<Perfil> olPerfiles = FXCollections.observableArrayList();

        this.colNombrePerfil.setCellValueFactory(new PropertyValueFactory("name"));
        this.colUsuarioPerfil.setCellValueFactory(new PropertyValueFactory("user"));

        for (Perfil temp : perfiles) {
            olPerfiles.add(temp);
        }

        tvwPerfiles.setItems(olPerfiles);
    }

    public void actualizarTablaProductos() {
        ArrayList<Publicacion> productos = inventario.inventarioPublicacion.obtenerInventario();
        ObservableList<Publicacion> olProductos = FXCollections.observableArrayList();

        this.colNombreProducto.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colCodigoProducto.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colDescripcionProducto.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPrecioProducto.setCellValueFactory(new PropertyValueFactory("precio"));

        for (Publicacion temp : productos) {
            olProductos.add(temp);
        }

        tvwProductos.setItems(olProductos);
    }

    public void actualizarTablaVentas() {
        ArrayList<Venta> ventas = inventario.inventarioVenta.obtenerInventario();
        ObservableList<Venta> olVentas = FXCollections.observableArrayList();

        this.colFechaVenta.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colProductosVenta.setCellValueFactory(new PropertyValueFactory("productos"));
        this.colMontoVenta.setCellValueFactory(new PropertyValueFactory("venta"));
        this.colPagoVenta.setCellValueFactory(new PropertyValueFactory("pago"));
        this.colCambioVenta.setCellValueFactory(new PropertyValueFactory("cambio"));

        for (Venta temp : ventas) {
            olVentas.add(temp);
        }

        tvwVentas.setItems(olVentas);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void add(ActionEvent event) {
        if (event.getSource().equals(this.btnAddPerfil)) {
            
        }
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void guardarCambio(ActionEvent event) {
    }

    @FXML
    private void aplicarFiltroProducto(ActionEvent event) {
    }

    @FXML
    private void guardarCambios(ActionEvent event) {
    }

    @FXML
    private void aplicarFiltroVenta(ActionEvent event) {
    }

    @FXML
    private void eliminarVentas(ActionEvent event) {
    }
}
