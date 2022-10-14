package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BankNet {
    private double [][] credits;
    private double safeLevel;
    private Function<Integer, String> mapToName;

    public BankNet(int bankCount, double safeLevel, Function<Integer, String> mapToName) {
        this.credits = new double [bankCount][bankCount];
        setSafeLevel(safeLevel);
        setMapToName(mapToName);
    }

    public double getSafeLevel() {
        return safeLevel;
    }

    public Function<Integer, String> getMapToName() {
        return mapToName;
    }

    public void setSafeLevel(double safeLevel) {
        if(safeLevel < 0)
            this.safeLevel = 500;
        else {
            this.safeLevel = safeLevel;
        }
    }

    public void setMapToName(Function<Integer, String> mapToName) {
        if(mapToName == null) {
            mapToName = e -> "Bank";
        }
        else {
            this.mapToName = mapToName;
        }
    }

    public boolean hasGivenCredit(int i, int j){
        return(credits[i][j] != 0);
    }

    public void setCredit(int i, int j, double credit){


        if(credit <= 0 || i >= credits.length || j >= credits[0].length || i < 0 || j < 0) return;

        credits[i][j] = credit;
    }

    public double getCredit (int i, int j){
        if(i >= credits.length || j >= credits[0].length || j < 0 || i < 0) return 0;
        return credits[i][j];
    }

    public void removeCredit(int i, int j){
        if(i >= credits.length || j >= credits[0].length || j < 0 || i < 0) return;

        credits[i][j] = 0;
    }

    public boolean isSafeBank(int i){
        if(i < 0 || i >= credits.length) return true; // returning true to not make changes

        double capital = 0;
        double creditsTaken = 0;

        for(int j = 0; j < credits[i].length; j++){
            capital += credits[i][j];
        }

        for(int t = 0; t < credits.length; t++){
            if(t == i) continue;

            creditsTaken += credits[t][i];
        }

        return !(creditsTaken > (85.0 / 100.0) * capital);
    }

    public void invalidateCredits(int i, double[][] transactions){
        if(i < 0 || i >= credits.length) return;

        for(int t = 0; t < credits.length; t++){
            if(t == i)
                continue;
            transactions[t][i] = 0;
        }
    }

    public List<String> findUnsafebanks(){
        double[][] transactions = new double[credits.length][credits.length];
        for (int i = 0; i < credits.length; i++) {
            for(int j = 0; j < credits[i].length; j++){
                transactions[i][j] = credits[i][j];
            }
        }

        List<Integer> unsafeBanks = new ArrayList<>();
        boolean found = true;
        while(found) {
            found = false;
            for (int i = 0; i < credits.length; i++) {
                if (!isSafeBank(i)) {
                    unsafeBanks.add(i);
                    found = true;
                    invalidateCredits(i, transactions);
                }
            }
        }

        return unsafeBanks.stream().map(mapToName).sorted().toList();
    }

    @Override
    public String toString() {
        String toReturn = String.format("Въведени банки\n" +
                "Ниво на надеждност: %.2f \n", safeLevel);

        for(int i = 0 ; i < credits.length; i++){
            for(int j = 0; j < credits[i].length; j++){
                if(credits[i][j] != 0){
                    toReturn += String.format("%s - %.2f - %s\n", mapToName.apply(i), credits[i][j], mapToName.apply(j));
                }
            }
        }

        return toReturn;
    }

}
