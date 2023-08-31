package com.example.atmmachine;

import com.example.atmmachine.models.Customer;
import com.example.atmmachine.models.CustomerDAO;
import com.example.atmmachine.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class Login {

    @FXML
    private PasswordField pinField;

    @FXML
    private TextField accountNumberField;


    private MainApp mainApp; // Reference to the MainApp instance

    @FXML
    void loginUser() {
        String accountNumber = this.accountNumberField.getText();
        String pin = pinField.getText();

        // Validate input
        if (accountNumber.isEmpty() || pin.isEmpty()) {
            showAlert("Error", "Please fill in both accountNumber and pin.");
        }
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            // Retrieve the user by accountNumber from the database
            Customer customer = customerDAO.getCustomerByAccountNumber(accountNumber);
            if (customer != null) {
                // Validate pin
                if (customer.getPin().equals(pin)) {
                    showAlert("Success", "Login successful!");
                    Session.setLoggedInUser(customer);
                    mainApp.showMenuScreen();
                } else {
                    showAlert("Error", "Incorrect pin");
                }
            } else {
                showAlert("Error", "User not found");
            }
        } catch (SQLException e) {
            showAlert("Error", "An error occurred during login.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


@FXML
    private void handleRegisterButtonAction(ActionEvent event) {
        try {
            mainApp.showRegisterScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init(MainApp mainApp){ this.mainApp = mainApp; }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
