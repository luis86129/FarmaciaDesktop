package org.example;

import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void onLogin() {
        // Aquí añadirás la validación de usuario/contraseña más adelante
        ViewNavigator.loadView("/views/HubView.fxml");
    }

    @FXML
    private void goBack() {
        ViewNavigator.loadView("/views/MainView.fxml");
    }
}