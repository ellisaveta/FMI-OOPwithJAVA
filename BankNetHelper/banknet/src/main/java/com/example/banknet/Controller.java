package com.example.banknet;

import com.BankNet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    private BankNet banks;
    private String[] bankNames = new String[]{"ПИ", "ОБ", "РФ", "АБ", "HS"};


    public void initialize(){
        banks = new BankNet(bankNames.length, 400, e -> {
            if(e >= bankNames.length || e < 0)
                return "Bank";
            return bankNames[e];
        });
    }

    @FXML
    private TextArea ta;

    @FXML
    private TextField tfFrom;

    @FXML
    private TextField tfTo;

    @FXML
    private TextField tfLoan;

    @FXML
    void btnAdd(ActionEvent event) {
        String from = tfFrom.getText();
        String to = tfTo.getText();
        String loan = tfLoan.getText();

        try {
            int fromInt = Integer.parseInt(from);
            int toInt = Integer.parseInt(to);
            double loanInt = Double.parseDouble(loan);
            banks.setCredit(fromInt, toInt, loanInt);
        }
        catch(NumberFormatException e){
            System.out.println("Wrong input data.");
        }

    }

    @FXML
    void btnExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnRemove(ActionEvent event) {
        String from = tfFrom.getText();
        String to = tfTo.getText();

        try {
            int fromInt = Integer.parseInt(from);
            int toInt = Integer.parseInt(to);

            banks.removeCredit(fromInt, toInt);
        }
        catch(NumberFormatException e){
            System.out.println("Wrong input data.");
        }
    }

    @FXML
    void btnShowAll(ActionEvent event) {
        ta.setText(banks.toString());
    }

    @FXML
    void btnShowUnsafe(ActionEvent event) {
        ta.setText(String.join("\n", banks.findUnsafebanks()));
    }

}
