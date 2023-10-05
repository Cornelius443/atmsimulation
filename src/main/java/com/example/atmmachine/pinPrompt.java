package com.example.atmmachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class pinPromptController {
    @FXML
    private PasswordField pinField;
    @FXML
    private Button submitButton;
    private Withdrawal withdrawalController;

    public void setWithdrawalController(Withdrawal withdrawalController) {
        this.withdrawalController = withdrawalController;
    }

    @FXML
    void submitPin(ActionEvent event) {
        String enteredPin = pinField.getText();

        // Validate the PIN (You need to implement this logic)
        boolean isValid = validatePin(enteredPin);

        if (isValid) {
            withdrawalController.continueTransaction(); // Proceed with the transaction
            closeDialog();
        } else {
            showAlert("Error", "Incorrect PIN. Please try again.");
        }
    }

    private boolean validatePin(String enteredPin) {
        // Implement your actual PIN validation logic
        String correctPin = "1234";
        return enteredPin.equals(correctPin);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void closeDialog() {
        submitButton.getScene().getWindow().hide();
    }
}
