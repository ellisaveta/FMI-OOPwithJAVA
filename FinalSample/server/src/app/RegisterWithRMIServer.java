package app;

import com.TimeServerInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegisterWithRMIServer {
    public static void main(String[] args) {
        String remote = "Remote";
        TimeServerInterface remoteObject;

        try {
            remoteObject = new TimeServerInterfaceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(remote, remoteObject);

            System.out.println("Object successfully registered!");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
