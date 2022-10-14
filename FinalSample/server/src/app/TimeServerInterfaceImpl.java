package app;

import com.TimeServerInterface;
import time.Time;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TimeServerInterfaceImpl extends UnicastRemoteObject implements TimeServerInterface {

    protected TimeServerInterfaceImpl() throws RemoteException {
    }

    @Override
    public Time setupClock(String clockName) throws RemoteException {
        Time time = new Time();
        time.setCurrentTime();
        System.out.printf("Time set on clock with name: %s\n", clockName);
        return time;
    }
}
