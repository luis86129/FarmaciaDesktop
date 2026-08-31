package org.example;

import javafx.fxml.FXML;

public class RegisterController {
    @FXML
    private void goBack() {
        ViewNavigator.loadView("/views/MainView.fxml");
    }
}