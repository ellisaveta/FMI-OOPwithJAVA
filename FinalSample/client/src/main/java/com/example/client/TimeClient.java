package com.example.client;

import com.TimeServerInterface;
import time.Clock;
import time.Time;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class TimeClient extends Application {
    private static int counter = 0;
    private int uid;

    private Clock clock;
    TimeServerInterface remoteTime;


    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        clock = new Clock();

        uid = counter++;

        Random random = new Random();
        String remote = "Remote";
        String title = String.format("Clock No. %d", uid);


        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        try {
            remoteTime = (TimeServerInterface) registry.lookup(remote);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        Time localTime;
        try{
            localTime = remoteTime.setupClock(title);
            localTime.setTimeZone(random.nextInt(26) - 12);
            clock.setClock(localTime);
        }
        catch (RemoteException e){
            e.printStackTrace();
        }

        Scene scene = new Scene(clock);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}