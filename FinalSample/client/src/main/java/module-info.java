module client {
    requires server;
    requires time;
    requires java.rmi;
    requires javafx.controls;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.client to javafx.graphics;
    exports com.example.client;
}