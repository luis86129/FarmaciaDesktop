package org.example.Vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppLogin extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label titulo = new Label("Ingrese Sus credenciales");
        VBox root = new VBox(15);

        HBox box1 = new HBox(30);
        TextField user = new TextField();
        user.setPromptText("Usuario");
        box1.getChildren().addAll(new Label("Ingrese su Usuario:"), user);
        box1.setAlignment(Pos.CENTER);

        HBox box2 = new HBox(30);
        PasswordField password = new PasswordField();
        password.setPromptText("Contraseña");
        box2.getChildren().addAll(new Label("Ingrese su Contraseña:"),password);
        box2.setAlignment(Pos.CENTER);

        HBox box3 = new HBox(50);
        Button Ingresar = new Button("Ingresar");
        Button Regresar = new Button("Regresar");
        box3.getChildren().addAll(Ingresar,Regresar);
        box3.setAlignment(Pos.BOTTOM_CENTER);


        Ingresar.setOnAction(event -> {
            if (Verificar()) {
                try {
                    AppHub loggear = new AppHub();

                    loggear.start(new Stage());

                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Usuario o Contraseña Incorrecta");
            }
        });

        Regresar.setOnAction(event -> {
            try {
                AppInicio Inicio = new AppInicio();

                Inicio.start(new Stage());

                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(titulo,box1,box2,box3);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Boolean Verificar(){
        return true;
    }
}
