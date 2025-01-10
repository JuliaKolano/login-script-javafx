package com.example.loginscriptjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppController {
    @FXML
    protected void onRegisterButtonClick() { System.out.println("Register Button Clicked"); }

    @FXML
    protected void onLoginButtonClick() { System.out.println("Login Button Clicked"); }
}