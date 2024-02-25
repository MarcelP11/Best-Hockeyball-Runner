module com.example.bestrunner {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.besthockeyballrunner to javafx.fxml;
    exports com.example.besthockeyballrunner;
}