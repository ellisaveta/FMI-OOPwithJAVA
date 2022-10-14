package banknet.app;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.function.Function;

import bank.data.BankInfo;
import bank.data.BankNet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class BankNetController {

    private BankNet banks;
    private String[] bankNames = new String[] { "ПИ", "ОБ", "РФ", "АБ", "HS"};

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddCredit;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnReadFile;

    @FXML
    private Button btnRemoveCredit;

    @FXML
    private Button btnSaveOnFile;

    @FXML
    private Button btnShowCredits;

    @FXML
    private Button btnShowUnsafeBanks;

    @FXML
    private TextArea txtAInfo;

    @FXML
    private TextField txtFrom;

    @FXML
    private TextField txtLoan;

    @FXML
    private TextField txtTo;

    @FXML
    void btnAddCreditOnAction(ActionEvent event) {
        int from = Integer.parseInt(txtFrom.getText());
        int to = Integer.parseInt(txtTo.getText());
        double loan = Double.parseDouble(txtLoan.getText());
        banks.setCredit(from, to, loan);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnReadFileOnAction(ActionEvent event) {
        double level;
        int numOfBanks = 0;

        String fileName;
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("File name");
        dialog.setContentText("Please enter file name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            fileName = result.get();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(fileName));
                String line = br.readLine();
                if(line != null) {
                    level = Double.parseDouble(line);
                    line = br.readLine();
                    if(line != null) {
                        numOfBanks = Integer.parseInt(line);
                        String[] banksNames = new String[numOfBanks];
                        line = br.readLine();
                        for (int i = 0; i < numOfBanks && line != null; i++) {
                            banksNames[i] = line;
                            line = br.readLine();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert br != null;
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @FXML
    void btnRemoveCreditOnAction(ActionEvent event) {
        int from = Integer.parseInt(txtFrom.getText());
        int to = Integer.parseInt(txtTo.getText());
        banks.setCredit(from, to, 0);
    }

    @FXML
    void btnSaveOnFileOnAciton(ActionEvent event) {
        String fileName;
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("File name");
        dialog.setContentText("Please enter file name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            fileName = result.get();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                Map<Integer, Map<Integer, Double>> creditInfo = new TreeMap<>();
                for (int i = 0; i < bankNames.length; i++) {
                    Map<Integer, Double> loansGiven = new TreeMap<>();
                    for (int j = 0; j < bankNames.length; j++) {
                        if(j != i && banks.getCredit(i, j) > 0) {
                            loansGiven.put(j, banks.getCredit(i, j));
                        }
                    }
                    creditInfo.put(i, loansGiven);
                }
                BankInfo bankInfo = new BankInfo(banks.getSafeLevel(), bankNames, creditInfo);
                writer.write(bankInfo.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnShowCreditsOnAction(ActionEvent event) {
        txtAInfo.setText(banks.toString());
    }

    @FXML
    void btnShowUnsafeBanksOnAction(ActionEvent event) {
        txtAInfo.setText(banks.findUnsafebanks().toString());
    }

    @FXML
    void initialize() {
        assert btnAddCredit != null : "fx:id=\"btnAddCredit\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert btnReadFile != null : "fx:id=\"btnReadFile\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert btnRemoveCredit != null : "fx:id=\"btnRemoveCredit\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert btnSaveOnFile != null : "fx:id=\"btnSaveOnFile\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert btnShowCredits != null : "fx:id=\"btnShowCredits\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert btnShowUnsafeBanks != null : "fx:id=\"btnShowUnsafeBanks\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert txtAInfo != null : "fx:id=\"txtAInfo\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert txtFrom != null : "fx:id=\"txtFrom\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert txtLoan != null : "fx:id=\"txtLoan\" was not injected: check your FXML file 'bankNet-view.fxml'.";
        assert txtTo != null : "fx:id=\"txtTo\" was not injected: check your FXML file 'bankNet-view.fxml'.";

        banks = new BankNet(bankNames.length, 400, e -> {
            if(e < 0 || e >= bankNames.length) {
                return "Bank";
            }
            return bankNames[e];
        });

    }

}
