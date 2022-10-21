package com.example.loginsystemdb;

import com.example.loginsystemdb.Register;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainModel {
    private Stage stage;
    private Scene scene;

    @FXML
    private Button logout;

    @FXML
    public void logout(ActionEvent event) throws IOException {
        Register register = new Register();
        register.switchToLoginPage(event);
    }
}
