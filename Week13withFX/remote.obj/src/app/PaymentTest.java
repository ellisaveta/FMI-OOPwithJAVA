package app;

import com.Payable;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Formatter;

public class PaymentTest {
    public static void main(String[] args) {
        String remoteObjectName = "Payment";
//        Formatter formatter;
//        File file = new File("RemoteObjectName.txt");
//        try {
//            formatter = new Formatter(file);
//            formatter.format(remoteObjectName);
//            formatter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("Remote.ser")
        )) {
            output.writeObject(remoteObjectName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Payable payable;
        try {
            payable = new Payment();
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind(remoteObjectName, payable);
            System.out.printf("Remote object with name %s is registered. " +
                    "Registry is running.\n", remoteObjectName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
