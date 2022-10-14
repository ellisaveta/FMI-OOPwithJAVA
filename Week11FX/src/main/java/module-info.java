module com.example.week11fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week11fx to javafx.fxml;
    exports com.example.week11fx;
}