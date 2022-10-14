package payment;

import com.Payable;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.NumberFormat;

public class PaymentFX extends Application {

    private TextField txtFRate;
    private TextField txtFLoanAmount;
    private TextField txtFMonths;

    private TextArea txtAOutput;

    private Payable payable;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnMonthlyPayment = new Button("Monthly Payment");
        Button btnTotalPayment = new Button("Total Payment");
        Label lblRate = new Label("Rate");
        Label lblLoanAmount = new Label("Loan amount");
        Label lblMonths = new Label("Months");
        txtFRate = new TextField();
        txtFLoanAmount = new TextField();
        txtFMonths = new TextField();
        txtAOutput = new TextArea();

        GridPane root = new GridPane();
        root.setVgap(8);
        root.setHgap(8);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(14));
        btnMonthlyPayment.setOnAction(e -> getMonthlyPayment());
        btnTotalPayment.setOnAction( e -> getTotalPayment());
        root.add(lblRate, 0, 0);
        root.add(txtFRate, 1, 0);
        root.add(lblLoanAmount, 0, 1);
        root.add(txtFLoanAmount, 1, 1);
        root.add(lblMonths, 0, 2);
        root.add(txtFMonths, 1, 2);
        root.add(btnMonthlyPayment, 0, 3);
        root.add(btnTotalPayment, 1, 3);
        btnMonthlyPayment.setAlignment(Pos.CENTER);
        btnTotalPayment.setAlignment(Pos.CENTER);
        root.add(txtAOutput, 0, 4, 2, 2);


        Scene scene = new Scene(root, 450, 300);
        initializeRMI();

        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setTitle("RMI Sample 1");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    protected void initializeRMI() {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost", 1099);
            payable = (Payable) registry.lookup("Payment");
            System.out.println("Server object " + payable + " found!");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }


    private void getMonthlyPayment() {
        double rate = Double.parseDouble(txtFRate.getText());
        double loanAmount = Double.parseDouble(txtFLoanAmount.getText());
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        double payment = 0;
        try {
            payment = payable.monthlyPayment(rate, loanAmount);
            txtAOutput.setText(String.format("Rate: %s, Loan amount: %s, Monthly payment: %s\n",
                    percentFormat.format(rate),
                    currencyFormat.format(loanAmount),
                    currencyFormat.format(payment)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    private void getTotalPayment() {
        double rate = Double.parseDouble(txtFRate.getText());
        double loanAmount = Double.parseDouble(txtFLoanAmount.getText());
        int months = Integer.parseInt(txtFMonths.getText());
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        double payment = 0;
        try {
            payment = payable.totalPayment(rate, loanAmount, months);
            txtAOutput.setText(String.format("Rate: %s, Loan amount: %s, Total payment for %d months: %s\n",
                    percentFormat.format(rate),
                    currencyFormat.format(loanAmount),
                    months,
                    currencyFormat.format(payment)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
