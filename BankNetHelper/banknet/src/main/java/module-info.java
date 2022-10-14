module com.example.banknet {
    requires javafx.controls;
    requires javafx.fxml;
    requires bank.data;
            
                        
    opens com.example.banknet to javafx.fxml;
    exports com.example.banknet;
}