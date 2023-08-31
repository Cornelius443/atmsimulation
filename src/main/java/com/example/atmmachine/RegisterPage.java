package com.example.atmmachine;
import com.example.atmmachine.models.Customer;
import com.example.atmmachine.models.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterPage {
    @FXML
    private TextField customerName;


    @FXML
    private TextField accountNumber;

    @FXML
    private TextField availableBalance;
    @FXML
    private TextField totalBalance;
    @FXML
    private PasswordField pin;
    private MainApp mainApp;

    @FXML
    void createUser() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer();
        customer.setCustomerName(customerName.getText());
        customer.setAccountNumber(accountNumber.getText());
        customer.setAvailableBalance(availableBalance.getText());
        customer.setTotalBalance(totalBalance.getText());
        customer.setPin(pin.getText());


        try{
            customerDAO.createUser(customer);
            showAlert("Success", "User created successfully");
            mainApp.showLoginScreen();
        }catch(SQLException e){
            showAlert("Error", "Unable to create user");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void init(MainApp mainApp){
    this.mainApp = mainApp;
}

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
@FXML
    private  void registerPage(ActionEvent event){
    try{
        mainApp.showRegisterScreen();
    }catch (Exception e){
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

