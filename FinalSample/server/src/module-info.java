module server {
    requires java.rmi;
    requires time;

    opens com to java.rmi;
    exports com;
}