package org.example.Vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInicio extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(15);

        Label label = new Label("¡Ingrese o Registrese!");

        Button Login = new Button("Iniciar Secion");
        Button Register = new Button("Registrarse");

        root.getChildren().setAll(label,Login,Register);

        root.setAlignment(Pos.CENTER);

        Login.setOnAction(event -> {
            try {
                AppLogin Ingresar = new AppLogin();

                Ingresar.start(new Stage());

                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Register.setOnAction(event -> {
            try {
                AppInicio Registrar = new AppInicio();

                Registrar.start(new Stage());

                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Login or Register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
