package server.com;

import model.com.TradeProduct;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerApplication {
    private TradeProduct trade;

    public ServerApplication() {
        trade = new TradeProduct();
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ServerApplication serverApplication = new ServerApplication();
    }
}
