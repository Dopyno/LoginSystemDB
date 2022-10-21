package com.example.loginsystemdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {
    LoginModel loginModel = new LoginModel();
    private Stage stage;
    private Scene scene;
    @FXML
    private Label message;
    @FXML
    private TextField user, pass1, pass2, name, address, email, phone;
    @FXML
    private Button registerButton, cancelButton, loginButton;

    @FXML
    public void switchToLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void createNewUser(ActionEvent event)throws Exception{
        if (user.getText().equals("") && pass1.getText().equals("")) {
            this.message.setText("Please enter a valid username and password!");
            clear();
        }else if (!pass1.getText().equals(pass2.getText())){
            this.message.setText("Password not match, please try again!");
            clear();
        }else {
            loginModel.addUserToDB(this.user.getText(), this.pass1.getText(), this.name.getText(), this.address.getText(), this.email.getText(), this.phone.getText());
            this.message.setText("User added successfully!");
            clear();
        }
    }
    @FXML
    public void clear(){
        user.setText("");
        pass1.setText("");
        pass2.setText("");
        name.setText("");
        address.setText("");
        email.setText("");
        phone.setText("");
    }
}
