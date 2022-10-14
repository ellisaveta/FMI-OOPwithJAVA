module com.example.moneyfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moneyfx to javafx.fxml;
    exports com.example.moneyfx;
}