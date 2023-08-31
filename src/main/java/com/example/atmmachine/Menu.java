package com.example.atmmachine;

import com.example.atmmachine.models.Customer;
import com.example.atmmachine.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Menu {
    private MainApp mainApp;

    @FXML
    private Label greetUser;

    public void initialize() {
        Customer loggedInUser = Session.getLoggedInUser();
        if (loggedInUser != null) {
            greetUser.setText("Welcome " + loggedInUser.getCustomerName() + "!");
        }
    }

    public void init(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }
    @FXML
    private void withdrawalButtonAction(ActionEvent event) {
        try {
            mainApp.showWithdrawalScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void DepositButtonAction(ActionEvent event) {
        try {
            mainApp.showDepositScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void balanceButtonAction(ActionEvent event) {
        try {
            mainApp.showBalanceScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        try {
            mainApp.showLandingPageScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
