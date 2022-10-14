package com.example.week11fx;

import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnExit;

    @FXML
    private TextField txX;

    @FXML
    private TextField txY;

    @FXML
    private TextField txZ;

    @FXML
    private TextField txtResult;

    private BigDecimal x , y, z;

    @FXML
    void btnComputeOnAction(ActionEvent event) {
        x = new BigDecimal(txX.getText());
        y = new BigDecimal(txY.getText());
        z = new BigDecimal(txZ.getText());

        BigDecimal result =
                new BigDecimal(4).multiply(x).multiply(x)
                        .divide((x.multiply(x).add(new BigDecimal(1))))
                        .subtract(new BigDecimal(9).multiply((y.add(x.multiply(z)))))
                        .add((new BigDecimal(3).add(y.multiply(new BigDecimal(2).add(x))))
                                .divide(y.multiply(y).add(new BigDecimal(4))));

        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        if(result.compareTo(new BigDecimal(10)) > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Conputation more than 10");
            alert.setContentText(String.format("result is %s", nf.format(result)));
            alert.showAndWait();
            txtResult.setText("");
        }
        txtResult.setText(nf.format(result));
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txX != null : "fx:id=\"txX\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txY != null : "fx:id=\"txY\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txZ != null : "fx:id=\"txZ\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
