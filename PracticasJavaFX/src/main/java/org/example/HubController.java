package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HubController {

    @FXML private Label lblWelcome;

    @FXML
    public void initialize() {
        String usuario = UserSession.getUsuarioLogueado();
        if (usuario != null) {
            lblWelcome.setText("Bienvenido, " + usuario);
        }
    }

    @FXML
    private void onLogout() {
        UserSession.cleanSession();
        ViewNavigator.loadView("/views/LoginView.fxml");
    }

    @FXML private void onOpenSales() {}
    @FXML private void onOpenInventory() {}
}