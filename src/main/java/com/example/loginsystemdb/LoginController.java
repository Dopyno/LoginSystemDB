package com.example.loginsystemdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    LoginModel loginModel = new LoginModel();
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton, cancelButton, registerButton;
    @FXML
    private Label message;


    @FXML
    public void switchToRegisterPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToMainWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainModel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        //stage.setMaximized(true);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(this.loginModel.isDatabaseConnected()){
            this.message.setText("DB Connected");
        }else {
            this.message.setText("Not connected to DB");
        }
    }
    @FXML
    public void login(ActionEvent event)throws IOException{
        try {
            if (this.loginModel.isLogin(this.user.getText(), this.password.getText()    )) {
                switchToMainWindow(event);
            }else {
                this.message.setText("Wrong credentials!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void clear(){ 
        user.setText("");
        password.setText("");
    }

}
