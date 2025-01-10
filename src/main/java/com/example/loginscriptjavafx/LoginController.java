package com.example.loginscriptjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    // Takes the user back to the home page
    @FXML
    protected void onCancelButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // gets the current stage
        stage.setScene(scene);
        stage.show();
    }

    // Will let the user log in or display error information
    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty()) {
            errorLabel.setText("Username cannot be empty.");
        } else if (password.isEmpty()) {
            errorLabel.setText("Password cannot be empty.");
        } else if (checkCredentials(username, password)) {

            // Take the user to the login success scene
            FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("login-success-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // gets the current stage
            stage.setScene(scene);
            stage.show();

        } else {
            errorLabel.setText("Invalid username or password. Try again.");
        }
    }

    // Check if the user credentials match with the stored users
    private boolean checkCredentials(String username, String password) {
        // Get the user credentials from the array list
        ArrayList<String[]> users = UserCredentials.getUsers();

        // check if any usernames and passwords match
        for (String[] user : users) {
            if (user[0].equalsIgnoreCase(username) && user[1].equals(password)) {
                return true;
            }
        }

        return false;
    }
}