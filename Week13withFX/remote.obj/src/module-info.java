module remote.obj {
    requires java.rmi;

    opens com to java.rmi;
    exports com;
}