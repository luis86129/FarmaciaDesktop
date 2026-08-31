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

public class AppRegister extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label titulo = new Label("Registre sus Datos");
        VBox root = new VBox(15);

        HBox box1 = new HBox(30);
        TextField name = new TextField();
        name.setPromptText("Nombre");
        box1.getChildren().addAll(new Label("Ingrese su Nombre:"), name);
        box1.setAlignment(Pos.CENTER);

        HBox box2 = new HBox(30);
        TextField lastname = new TextField();
        lastname.setPromptText("Apellido");
        box2.getChildren().addAll(new Label("Ingrese su Apellido:"), lastname);
        box2.setAlignment(Pos.CENTER);

        HBox box3 = new HBox(30);
        TextField user = new TextField();
        user.setPromptText("Usuario");
        box3.getChildren().addAll(new Label("Ingrese su Usuario:"), user);
        box3.setAlignment(Pos.CENTER);

        HBox box4 = new HBox(30);
        TextField mail = new TextField();
        mail.setPromptText("Correo");
        box4.getChildren().addAll(new Label("Ingrese su Correo:"), mail);
        box4.setAlignment(Pos.CENTER);

        HBox box5 = new HBox(30);
        PasswordField password = new PasswordField();
        password.setPromptText("Contraseña");
        box5.getChildren().addAll(new Label("Ingrese una Contraseña:"),password);
        box5.setAlignment(Pos.CENTER);

        HBox box6 = new HBox(30);
        PasswordField passwordconfirmation = new PasswordField();
        passwordconfirmation.setPromptText("Confirmar Contraseña");
        box6.getChildren().addAll(new Label("Confirme su Contraseña:"),passwordconfirmation);
        box6.setAlignment(Pos.CENTER);

        HBox box7 = new HBox(50);
        Button Registrar = new Button("Registrarse");
        Button Regresar = new Button("Regresar");
        box7.getChildren().addAll(Registrar,Regresar);
        box7.setAlignment(Pos.BOTTOM_CENTER);

        root.getChildren().addAll(box1,box2,box3,box4,box5,box6,box7);

        root.setAlignment(Pos.CENTER);

        Registrar.setOnAction(event -> {
            if (Verificar()) {
                try {
                    AppInicio Regist = new AppInicio();

                    Regist.start(new Stage());

                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Contrasena igual etc");
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

        Scene scene = new Scene(root, 400, 600);
        scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean Verificar(){
        return true;
    }
}
