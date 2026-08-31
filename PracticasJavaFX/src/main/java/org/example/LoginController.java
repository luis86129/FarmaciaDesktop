package org.example;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    @FXML
    private void onLogin() {
        String email = txtEmail.getText().trim();
        String pass = txtPassword.getText();

        if (email.isEmpty() || pass.isEmpty()) {
            showError("Por favor completa todos los campos.");
            return;
        }

        String usuarioNombre = DatabaseManager.authenticateUser(email, pass);
        if (usuarioNombre != null) {
            UserSession.setUsuarioLogueado(usuarioNombre);
            ViewNavigator.loadView("/views/HubView.fxml");
        } else {
            showError("Correo o contraseña incorrectos.");
        }
    }

    private void showError(String msg) {
        lblError.setText(msg);
        lblError.setVisible(true);
        lblError.setManaged(true);
    }

    @FXML
    private void goBack() {
        ViewNavigator.loadView("/views/MainView.fxml");
    }
}