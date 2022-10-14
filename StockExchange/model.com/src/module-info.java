module model.com {
    requires javafx.controls;
    requires javafx.fxml;

    opens model.com to javafx.fxml;
    exports model.com;
}