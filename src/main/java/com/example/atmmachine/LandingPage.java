package com.example.atmmachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class LandingPage {

private MainApp mainApp;



    public void init(MainApp mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
        try {
            mainApp.showRegisterScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        try {
            mainApp.showLoginScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
