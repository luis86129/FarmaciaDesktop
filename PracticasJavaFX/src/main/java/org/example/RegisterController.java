package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private void onRegister() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String pass = txtPassword.getText();

        // Verificaciones básicas
        if (nombre.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            showStatus("Todos los campos son obligatorios.", true);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            showStatus("Formato de correo no válido.", true);
            return;
        }

        if (pass.length() < 6) {
            showStatus("La contraseña debe tener al menos 6 caracteres.", true);
            return;
        }

        boolean exito = DatabaseManager.registerUser(nombre, email, pass);
        if (exito) {
            showStatus("¡Cuenta creada con éxito! Redirigiendo...", false);
            ViewNavigator.loadView("/views/LoginView.fxml");
        } else {
            showStatus("El correo ya se encuentra registrado.", true);
        }
    }

    private void showStatus(String msg, boolean isError) {
        lblStatus.setText(msg);
        lblStatus.setStyle(isError ? "-fx-text-fill: #ef4444;" : "-fx-text-fill: #22c55e;");
        lblStatus.setVisible(true);
        lblStatus.setManaged(true);
    }

    @FXML
    private void goBack() {
        ViewNavigator.loadView("/views/MainView.fxml");
    }
}