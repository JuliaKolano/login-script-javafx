package com.example.loginscriptjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    // Take the user to the register screen
    @FXML
    protected void onRegisterButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow(); // gets the current stage
        stage.setScene(scene);
        stage.show();
    }

    // Take the user to the login scene
    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow(); // gets the current stage
        stage.setScene(scene);
        stage.show();
    }
}