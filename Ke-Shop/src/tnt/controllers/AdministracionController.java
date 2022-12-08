/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tnt.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import tnt.almacen.GestorInventario;
import tnt.cajero.Venta;
import tnt.perfil.Perfil;
import tnt.publicacion.Publicacion;

/**
 * Controldador para la modificacion de los datos persistentes
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
    private ChoiceBox<String> cbFiltroVenta;
    @FXML
    private Button btnBuscarVenta;
    @FXML
    private Button btnEliminarVentas;
    @FXML
    private Button btnRefrescarPerfiles;
    @FXML
    private Button btnRefrescarProductos;
    @FXML
    private Button btnRefrescarVentas;
    @FXML
    private Button btnFiltrarVenta;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TableColumn<Perfil, String> colPasswordPerfil;

    /**
     * Inicia el acceso al inventario
     *
     * @param inventario
     */
    public void setInventario(GestorInventario inventario) {
        this.inventario = inventario;

        cbFiltroProducto.getItems().addAll("Nombre", "Código", "Descripción");
        cbFiltroVenta.getItems().addAll("Este año", "Esta mes", "Hoy");
    }

    /**
     * Personaliza el nombre dependiendo del usuario
     *
     * @param perfil
     */
    public void setUsuario(Perfil perfil) {
        lNombreUsuario.setText(perfil.getName());
    }

    /**
     * Actualiza la tabla de perfiles con la informacion del inventario de
     * perfiles
     */
    public void actualizarTablaPerfiles() {
        ArrayList<Perfil> perfiles = inventario.inventarioPerfil.obtenerInventario();
        ObservableList<Perfil> olPerfiles = FXCollections.observableArrayList();

        for (Perfil temp : perfiles) {
            olPerfiles.add(temp);
        }

        tvwPerfiles.setItems(olPerfiles);
    }

    /**
     * Actualiza la tabla de productos con la información del inventario de
     * productos
     */
    public void actualizarTablaProductos() {
        ArrayList<Publicacion> productos = inventario.inventarioPublicacion.obtenerInventario();
        ObservableList<Publicacion> olProductos = FXCollections.observableArrayList();

        for (Publicacion temp : productos) {
            olProductos.add(temp);
        }

        tvwProductos.setItems(olProductos);
    }

    /**
     * Actualiza la tabla de ventas con la informacion del inventario de ventas
     */
    public void actualizarTablaVentas() {
        ArrayList<Venta> ventas = inventario.inventarioVenta.obtenerInventario();
        ObservableList<Venta> olVentas = FXCollections.observableArrayList();

        for (Venta temp : ventas) {
            olVentas.add(temp);
        }

        tvwVentas.setItems(olVentas);
    }

    /**
     * Genera un mensaje emergente de advertencia
     */
    private void msgNoSeleccion() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Debe seleccionar algo primero");
        alerta.show();
    }

    private void msgFiltro() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);

        alerta.setTitle("ADVERTENCIA");
        alerta.setHeaderText("Debe seleccionar un filtro primero");
        alerta.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Tabla de Perfiles
        this.colNombrePerfil.setCellValueFactory(new PropertyValueFactory("name"));
        this.colUsuarioPerfil.setCellValueFactory(new PropertyValueFactory("user"));
        this.colPasswordPerfil.setCellValueFactory((CellDataFeatures<Perfil, String> p) 
                -> new ReadOnlyObjectWrapper(p.getValue().getPassword().replaceAll("[a-zA-Z0-9]", "*")));
        
        //Tabla de Productos
        this.colNombreProducto.setCellValueFactory(new PropertyValueFactory("name"));
        this.colCodigoProducto.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colDescripcionProducto.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPrecioProducto.setCellValueFactory(new PropertyValueFactory("precio"));
        
        //Tabla de Ventas
        this.colFechaVenta.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colProductosVenta.setCellValueFactory(new PropertyValueFactory("productos"));
        this.colMontoVenta.setCellValueFactory(new PropertyValueFactory("venta"));
        this.colPagoVenta.setCellValueFactory(new PropertyValueFactory("pago"));
        this.colCambioVenta.setCellValueFactory(new PropertyValueFactory("cambio"));
    }

    /**
     * Te regresa al menú principal (El login)
     *
     * @param event
     */
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

    /**
     * Detecta desde que botón proviene la llamada y añade a su respectiva lista
     * un nuevo objeto.
     *
     * @param event
     */
    @FXML
    private void add(ActionEvent event) {
        try {
            if (event.getSource().equals(this.btnAddPerfil)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/EDPerfil.fxml"));
                Parent root = loader.load();
                EDPerfilController controlador = loader.getController();

                Scene escena = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(escena);
                stage.setTitle("Nuevo Cajero");

                stage.show();

                controlador.iniciar(inventario, this, 0);
            } else if (event.getSource().equals(this.btnAddProducto)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/EDPublicacion.fxml"));
                Parent root = loader.load();
                EDPublicacionController controlador = loader.getController();

                Scene escena = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(escena);
                stage.setTitle("Nuevo Producto");

                stage.show();

                controlador.iniciar(inventario, this, 0);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Detecta desde que botón proviene la llamada y edita el objeto
     * seleccionado de su respectiva lista.
     *
     * @param event
     */
    @FXML
    private void editar(ActionEvent event) {
        try {
            if (event.getSource().equals(this.btnEditarPerfil)) {
                Perfil perfilSel = tvwPerfiles.getSelectionModel().getSelectedItem();

                int index = 0;

                if (perfilSel != null) {
                    for (Perfil temp : inventario.inventarioPerfil.obtenerInventario()) {
                        if (!perfilSel.equals(temp)) {
                            index++;
                        }
                    }

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/EDPerfil.fxml"));
                    Parent root = loader.load();
                    EDPerfilController controlador = loader.getController();

                    Scene escena = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(escena);
                    stage.setTitle("Crear Cajero");

                    stage.show();

                    controlador.setIndexPerfil(perfilSel, index);
                    controlador.iniciar(inventario, this, 1);
                } else {
                    msgNoSeleccion();
                }
            } else if (event.getSource().equals(this.btnEditarProducto)) {
                Publicacion publicacionSel = tvwProductos.getSelectionModel().getSelectedItem();

                int index = 0;

                if (publicacionSel != null) {
                    for (Publicacion temp : inventario.inventarioPublicacion.obtenerInventario()) {
                        if (!publicacionSel.equals(temp)) {
                            index++;
                        }
                    }

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/tnt/gui/EDPublicacion.fxml"));
                    Parent root = loader.load();
                    EDPublicacionController controlador = loader.getController();

                    Scene escena = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(escena);
                    stage.setTitle("Nuevo Producto");

                    stage.show();

                    controlador.setIndexProducto(publicacionSel, index);
                    controlador.iniciar(inventario, this, 1);
                } else {
                    msgNoSeleccion();
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Detecta desde que botón proviene la llamada y elimina el objeto
     * seleccionado de su respectiva lista.
     *
     * @param event
     */
    @FXML
    private void eliminar(ActionEvent event) {
        if (event.getSource().equals(this.btnEliminarPerfil)) {
            Perfil perfilSel = tvwPerfiles.getSelectionModel().getSelectedItem();

            int index = 0;

            if (perfilSel != null) {
                if (index == 0) {
                    Alert alerta = new Alert(Alert.AlertType.WARNING);

                    alerta.setTitle("ADVERTENCIA");
                    alerta.setHeaderText("No puedes eliminar el perfil del administrador");
                    alerta.show();
                } else {
                    for (Perfil temp : inventario.inventarioPerfil.obtenerInventario()) {
                        if (!perfilSel.equals(temp)) {
                            index++;
                        }
                    }

                    inventario.inventarioPerfil.borrar(index);
                    actualizarTablaPerfiles();
                }
            } else {
                msgNoSeleccion();
            }
        } else if (event.getSource().equals(this.btnEliminarProducto)) {
            Publicacion publicacionSel = tvwProductos.getSelectionModel().getSelectedItem();

            int index = 0;

            if (publicacionSel != null) {
                for (Publicacion temp : inventario.inventarioPublicacion.obtenerInventario()) {
                    if (!publicacionSel.equals(temp)) {
                        index++;
                    }
                }

                inventario.inventarioPublicacion.borrar(index);
                actualizarTablaProductos();
            } else {
                msgNoSeleccion();
            }
        }
    }

    /**
     * Buscador por codigo, nombre o descirpcion de productos, muestra su tabla
     * resultante
     *
     * @param event
     */
    @FXML
    private void aplicarFiltroProducto(ActionEvent event) {
        String filtro = this.cbFiltroProducto.getValue();
        String buscar = this.tfBuscadorProducto.getText().toUpperCase();

        if (filtro != null) {
            ArrayList<Publicacion> productos = GestorInventario.inventarioPublicacion.obtenerInventario();
            ObservableList<Publicacion> olProductos = FXCollections.observableArrayList();
            
            for (Publicacion temp : productos) {
                if (filtro.equals("Nombre")) {
                    if (temp.getName().toUpperCase().contains(buscar)) {
                        olProductos.add(temp);
                    }
                } else if (filtro.equals("Codigo")) {
                    if (temp.getCodigo().toUpperCase().contains(buscar)) {
                        olProductos.add(temp);
                    }
                } else {
                    if (temp.getDescripcion().toUpperCase().contains(buscar)) {
                        olProductos.add(temp);
                    }
                }
            }

            tvwProductos.setItems(olProductos);
        } else {
            msgFiltro();
        }
    }

    /**
     * Detecta desde que botón proviene la llamada y guarda su respectiva lista.
     *
     * @param event
     */
    @FXML
    private void guardarCambios(ActionEvent event) {
        if (event.getSource().equals(this.btnGuardarCambiosPerfil)) {
            inventario.inventarioPerfil.guardarInvetario();
        } else if (event.getSource().equals(this.btnGuardarCambiosProducto)) {
            inventario.inventarioPublicacion.guardarInvetario();
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Guardado");
        alerta.setHeaderText("Se ha guardado correctamente");
        alerta.show();
    }

    /**
     * Detecta si se filtro o se busco, y hace la respectiva operacion. Busca en
     * una fecha en concreto, En este año, mes u hoy
     *
     * @param event
     */
    @FXML
    private void aplicarFiltroVenta(ActionEvent event) {
        String filtro = this.cbFiltroVenta.getValue();

        LocalDate fechapck = dpFecha.getValue();
        String buscar = this.tfBuscadorProducto.getText().toUpperCase();

        ArrayList<Venta> ventas = inventario.inventarioVenta.obtenerInventario();
        ObservableList<Venta> olVentas = FXCollections.observableArrayList();
        
        if (fechapck != null && filtro == null) {
            Date fechaIngresada = new Date(
                    fechapck.getYear(),
                    fechapck.getMonthValue(),
                    fechapck.getDayOfMonth()
            );

            Date fechaActual = new Date();

            for (Venta temp : ventas) {
                if (event.getSource().equals(this.btnFiltrarVenta)) {
                    switch (this.cbFiltroVenta.getValue()) {
                        case "Este año":
                            if (temp.getFecha().getYear() == fechaActual.getYear()) {
                                olVentas.add(temp);
                            }
                            break;
                        case "Este mes":
                            if (temp.getFecha().getMonth() == fechaActual.getMonth()) {
                                olVentas.add(temp);
                            }
                            break;
                        case "Hoy":
                            if (temp.getFecha().getDate() == fechaActual.getDate()) {
                                olVentas.add(temp);
                            }
                            break;
                        default:
                            break;
                    }
                } else if (event.getSource().equals(this.btnBuscarVenta)) {
                    if (fechaIngresada.equals(temp.getFecha())) {
                        olVentas.add(temp);
                    }
                }
            }
            
            tvwVentas.setItems(olVentas);
        } else {
            msgFiltro();
        }
    }

    /**
     * Elimina el inventario de ventas
     *
     * @param event
     */
    @FXML
    private void eliminarVentas(ActionEvent event) {
        inventario.inventarioVenta.eliminarInventario();
        actualizarTablaVentas();
    }

    /**
     * Detecta desde que botón proviene la llamada y actualiza su respectiva
     * lista, cargando los actuales elementos de sus inventarios.
     *
     * @param event
     */
    @FXML
    private void refrescar(ActionEvent event) {
        if (event.getSource().equals(this.btnRefrescarPerfiles)) {
            actualizarTablaPerfiles();
        } else if (event.getSource().equals(this.btnRefrescarProductos)) {
            actualizarTablaProductos();
        } else if (event.getSource().equals(this.btnRefrescarVentas)) {
            actualizarTablaVentas();
        }
    }
}
