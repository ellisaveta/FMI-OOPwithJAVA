package com.example.moneyfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MoneyController {

    private double money;
    private double interest;


    private String printFor10Years(double money, double interest, boolean EUR)
    {
        String result = "";
        for (int i = 1; i <= 10; i++) {
            result = result.concat(String.format("Year %d: %.2f %s\n", i, money, EUR ? "EUR" : "USD"));
            money += interest * money;
        }
        return result;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEur;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnUsd;

    @FXML
    private TextField txtInterest;

    @FXML
    private TextField txtLv;


    @FXML
    void btnEurOnActon(ActionEvent event) {
        final double TO_EUR = 0.51;
        double moneyEUR;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(String.format("EUR with %s%% interest for 10 years:", txtInterest.getText().equals("") ? "0" : txtInterest.getText()));
        alert.setWidth(500);

        try {
            money = Double.parseDouble(txtLv.getText());
            interest = Double.parseDouble(txtInterest.getText()) / 100;
        }
        catch (Exception ex)
        {
            money = 0;
            interest = 0;
        }
        moneyEUR = money * TO_EUR;
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(new TextArea(String.format("%.2f lv. = %.2f EUR\n%s",
                money, moneyEUR, printFor10Years(moneyEUR, interest, true))));
        alert.getDialogPane().setContent(scroll);
        alert.showAndWait();
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnUsdOnAction(ActionEvent event) {
        final double TO_USD = 0.58;
        double moneyUSD;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(String.format("USD with %s%% interest for 10 years:", txtInterest.getText().equals("") ? "0" : txtInterest.getText()));
        alert.setWidth(500);

        try {
            money = Double.parseDouble(txtLv.getText());
            interest = Double.parseDouble(txtInterest.getText()) / 100;
        }
        catch (Exception ex)
        {
            money = 0;
            interest = 0;
        }
        moneyUSD = money * TO_USD;
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(new TextArea(String.format("%.2f lv. = %.2f USD\n%s",
                money, moneyUSD, printFor10Years(moneyUSD, interest, false))));
        alert.getDialogPane().setContent(scroll);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnEur != null : "fx:id=\"btnEur\" was not injected: check your FXML file 'money-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'money-view.fxml'.";
        assert btnUsd != null : "fx:id=\"btnUsd\" was not injected: check your FXML file 'money-view.fxml'.";
        assert txtInterest != null : "fx:id=\"txtInterest\" was not injected: check your FXML file 'money-view.fxml'.";
        assert txtLv != null : "fx:id=\"txtLv\" was not injected: check your FXML file 'money-view.fxml'.";

    }

}
