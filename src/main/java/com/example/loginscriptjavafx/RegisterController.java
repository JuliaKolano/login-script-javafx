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

public class RegisterController {
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

    // Will let the user register or display error information
    @FXML
    protected void onRegisterButtonClick(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty()) {
            errorLabel.setText("Username cannot be empty.");
        } else if (password.isEmpty()) {
            errorLabel.setText("Password cannot be empty.");
        } else if (validUsername(username) && validPassword(password)) {
            // Add the user credentials to the array list of users
            ArrayList<String[]> users = UserCredentials.getUsers();
            users.add(new String[]{username, password});

            // Take the user to the login success scene
            FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("register-success-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // gets the current stage
            stage.setScene(scene);
            stage.show();

        } else if (!validUsername(username)) {
            errorLabel.setText("Username already exists. Try again.");
        } else if (!validPassword(password)) {
            errorLabel.setText("Password must be at least 8 characters long and contain at least one number and one capital letter. Try again.");
        }
        else {
            errorLabel.setText("Invalid username or password. Try again.");
        }
    }

    // The username must be unique
    private boolean validUsername(String username) {
        // Get the user credentials from the array list
        ArrayList<String[]> users = UserCredentials.getUsers();
        boolean valid = false;

        // check if the username already exists in the array list
        for (String[] user : users) {
            if (!(user[0].equalsIgnoreCase(username))) {
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    // Check if the password is valid
    private boolean validPassword(String password) {
        return password.length() >= 8 && // must be at least 8 characters long
                password.matches(".*\\d.*") && // must have at least one number
                password.matches(".*[A-Z].*"); // must have at least one capital letter
    }
}
