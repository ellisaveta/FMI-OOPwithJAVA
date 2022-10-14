package payment;

import com.Payable;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.NumberFormat;
import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        String remoteObjName = "";
//        try (Scanner scanner = new Scanner(new File("RemoteObjectName.txt"))) {
//            remoteObjName = scanner.next();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Remote.ser"))) {
            remoteObjName = (String)inputStream.readObject();
            System.out.println(remoteObjName);
            //no close method necessary because of try-with-resources
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Payable payable = (Payable) registry.lookup(remoteObjName);

            double rate = 0.01;
            double loanAmount = 1000;
            NumberFormat percentFormat = NumberFormat.getPercentInstance();
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

            double payment = payable.monthlyPayment(rate, loanAmount);
            System.out.printf("Rate: %s, Loan amount: %s, Monthly payment: %s\n",
                    percentFormat.format(rate),
                    currencyFormat.format(loanAmount),
                    currencyFormat.format(payment));

            payment = payable.totalPayment(rate, loanAmount, 12);
            System.out.printf("Rate: %s, Loan amount: %s, Total (1 year) payment: %s\n",
                    percentFormat.format(rate),
                    currencyFormat.format(loanAmount),
                    currencyFormat.format(payment));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
