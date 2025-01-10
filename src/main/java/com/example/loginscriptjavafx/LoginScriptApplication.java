package com.example.loginscriptjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScriptApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Populate the user credentials array list
        new UserCredentials();

        // Load the initial scene
        FXMLLoader fxmlLoader = new FXMLLoader(LoginScriptApplication.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Login Script Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}