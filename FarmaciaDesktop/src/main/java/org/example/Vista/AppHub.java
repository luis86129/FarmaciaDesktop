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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hola :D");

        VBox root = new VBox(10);
        root.getChildren().addAll(label);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
        primaryStage.setTitle("Tabla de Productos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
