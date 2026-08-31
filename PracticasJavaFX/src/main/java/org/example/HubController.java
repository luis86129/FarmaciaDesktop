package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HubController {

    @FXML
    private Label lblWelcome;

    @FXML
    public void initialize() {
        // Aquí podrás cargar datos del usuario autenticado más adelante
    }

    @FXML
    private void onOpenSales() {
        System.out.println("Navegando al módulo de Ventas...");
        // Próximamente: ViewNavigator.loadView("/views/SalesView.fxml");
    }

    @FXML
    private void onOpenInventory() {
        System.out.println("Navegando al módulo de Inventario...");
        // Próximamente: ViewNavigator.loadView("/views/InventoryView.fxml");
    }

    @FXML
    private void onLogout() {
        // Vuelve al Login al cerrar sesión
        ViewNavigator.loadView("/views/LoginView.fxml");
    }
}