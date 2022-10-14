package com;

import java.util.HashMap;
import java.util.Map;

public class BankInfo {
    private double level;
    private  String[] bankTitles;
    private Map<Integer, Map<Integer,Double>> creditInfo;

    public String[] getBankTitles() {
        String[] toReturn = new String[bankTitles.length];
        System.arraycopy(bankTitles, 0, toReturn, 0, bankTitles.length);
        return toReturn;
    }

    public Map<Integer, Map<Integer, Double>> getCreditInfo() {
        return new HashMap<>(creditInfo);
    }

    public void setBankTitles(String[] bankTitles) {
        if(bankTitles == null){
            this.bankTitles = new String[]{"ПИ", "ОБ", "РФ", "АБ", "HS"};
            return;
        }

        this.bankTitles = new String[bankTitles.length];
        System.arraycopy(bankTitles, 0, this.bankTitles, 0, bankTitles.length);
    }

    public void setCreditInfo(Map<Integer, Map<Integer, Double>> creditInfo) {
        this.creditInfo = new HashMap<>(creditInfo);
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        if(level < 0)
            this.level = 400;
        else
            this.level = level;
    }

    public BankInfo() {
        setLevel(400);
        setBankTitles(new String[]{"ПИ", "ОБ", "РФ", "АБ", "HS"});
        setCreditInfo(new HashMap<>());
    }

    public BankInfo(double level, String[] bankTitles, Map<Integer, Map<Integer, Double>> creditInfo) {
        setLevel(level);
        setBankTitles(bankTitles);
        setCreditInfo(creditInfo);
    }
}
