module client.app {
    requires java.rmi;
    requires remote.obj;

    requires javafx.controls;
    opens payment to javafx.graphics;

}