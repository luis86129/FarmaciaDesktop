package org.example.Vista;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppHub extends Application {

    public static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tabla.getColumns().addAll(colNombre, colPrecio);

        ObservableList<Producto> listaDatos = FXCollections.observableArrayList(
                new Producto("Paracetamol", 2.50),
                new Producto("Ibuprofeno", 3.10),
                new Producto("Amoxicilina", 8.00),
                new Producto("Penicilina" , 9.00)
        );

        tabla.setItems(listaDatos);

        VBox root = new VBox(10, tabla);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Tabla de Productos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
