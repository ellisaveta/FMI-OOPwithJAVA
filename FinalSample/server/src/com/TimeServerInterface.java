package com;

import java.rmi.Remote;
import java.rmi.RemoteException;

import time.Time;

public interface TimeServerInterface extends Remote {
    Time setupClock(String clockName) throws RemoteException;
}
