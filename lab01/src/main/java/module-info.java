module com.example.lab01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab01 to javafx.fxml;
    exports com.example.lab01;
}