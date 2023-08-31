module com.example.atmmachine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.atmmachine to javafx.fxml;
    exports com.example.atmmachine;
}

