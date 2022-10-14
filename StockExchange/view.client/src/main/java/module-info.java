module view.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires model.com;
    requires java.rmi;


    opens view.client to javafx.fxml;
    exports view.client;
}