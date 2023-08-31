package com.example.atmmachine;

import com.example.atmmachine.models.Customer;
import com.example.atmmachine.models.CustomerDAO;
import com.example.atmmachine.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Withdrawal {
    @FXML
    private TextField amountField;
    @FXML
    private Label userGreet;
    private MainApp mainApp;

    private int userId;

    public int initialize() {

        Customer loggedInUser = Session.getLoggedInUser();
        if (loggedInUser != null) {
            userGreet.setText("Hi " + loggedInUser.getCustomerName() + "!");
            userId = loggedInUser.getId();
        }
        return userId;
    }

    @FXML
    void debit(ActionEvent event) {
        String amountText = amountField.getText();

        if (amountText.isEmpty()) {

            // Handle empty amount field error
            showAlert("Error", "Please fill in desired amount.");
            return;
        }

            double amount = Double.parseDouble(amountText);
    try{
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.withdraw(userId, amount);

        showAlert("Success", "Withdrawal successful.");
    }catch (IllegalArgumentException e) {
        showAlert("Error", e.getMessage());
    } catch (SQLException e) {
        showAlert("Error", "An error occurred while processing the withdrawal.");
        e.printStackTrace();
    }

    }



    public void init(MainApp mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void menuButtonAction(ActionEvent event) {
        try {
            mainApp.showMenuScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
