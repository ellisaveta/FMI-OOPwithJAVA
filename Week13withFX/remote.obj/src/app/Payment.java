package app;

import com.Payable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Payment extends UnicastRemoteObject
        implements Payable {

    protected Payment() throws RemoteException {
    }

    @Override
    public double monthlyPayment(double rate, double loanAmount) throws RemoteException {
        return rate * loanAmount / 12; //annual rate
    }

    @Override
    public double totalPayment(double rate, double loanAmount, int months) throws RemoteException {
        return monthlyPayment(rate, loanAmount) * months;
    }
}
