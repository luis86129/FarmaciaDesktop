package org.example;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema Farmacia Hola commit 2");
        DatabaseManager.initDatabase(); // <-- Inicializa SQLite
        // Cargar el icono desde los recursos
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        primaryStage.getIcons().add(icon);

        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadView("/views/MainView.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}