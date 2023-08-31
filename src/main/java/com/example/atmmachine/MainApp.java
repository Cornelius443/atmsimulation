package com.example.atmmachine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class MainApp extends Application{

    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        showLandingPageScreen();
    }

    public void showRegisterScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registerPage.fxml"));
        Parent root = loader.load();
        RegisterPage registerController = loader.getController();

        Scene scene = new Scene(root, 600, 410);
        primaryStage.setScene(scene);
        primaryStage.show();
        registerController.init(this);
    }

    public void showLoginScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Login loginController = loader.getController();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        loginController.init(this);
    }
    public void showLandingPageScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("landing_page.fxml"));
        Parent root = loader.load();
        LandingPage landing = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        landing.init(this);



    }


    public void showMenuScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        Menu menu = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        menu.init(this);




    }

    public void showWithdrawalScreen() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("withdrawal.fxml"));
        Parent root = loader.load();
       Withdrawal withdrawal = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        withdrawal.init(this);
    }

    public void showDepositScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Parent root = loader.load();
        Menu menu = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showBalanceScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("balance.fxml"));
        Parent root = loader.load();
        Menu menu = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
