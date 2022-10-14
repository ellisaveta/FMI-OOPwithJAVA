module banknet.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires bank.data;


    opens banknet.app to javafx.fxml;
    exports banknet.app;
}