package org.example;

import javafx.fxml.FXML;

public class MainController {
    @FXML
    private void goToLogin() {
        ViewNavigator.loadView("/views/LoginView.fxml");
    }

    @FXML
    private void goToRegister() {
        ViewNavigator.loadView("/views/RegisterView.fxml");
    }
}
