package com;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Payable extends Remote {
    double monthlyPayment(double rate, double loanAmount)
        throws RemoteException;
    double totalPayment(double rate, double loanAmount, int months)
            throws RemoteException;
}
