package org.example.Vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(15);

        Label label = new Label("¡Bienvenido a la app de Farmacia!");

        Button Ingresar = new Button("Ingresar");
        Button Cerrar = new Button("Salir");

        root.getChildren().addAll(label,Ingresar,Cerrar);
        root.setAlignment(Pos.CENTER);

        Ingresar.setOnAction(event -> {
            try {
                AppInicio Inicio = new AppInicio();

                Inicio.start(new Stage());

                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Cerrar.setOnAction(event -> {
            stage.close();
        });

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Initial");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}