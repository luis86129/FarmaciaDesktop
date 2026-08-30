package org.example.Vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppHub extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hola = new Label("Hola :D");
        HBox box1 = new HBox(20);
        VBox root = new VBox(20);
        box1.getChildren().addAll(hola);
        box1.setAlignment(Pos.CENTER);
        root.getChildren().addAll(box1);
        root.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
