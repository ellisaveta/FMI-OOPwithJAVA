package bank.data;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class BankInfo {
    private double level;
    private String[] bankTitles;
    private  Map<Integer, Map<Integer,Double>> creditInfo;

    public BankInfo(double level, String[] bankTitles, Map<Integer, Map<Integer, Double>> creditInfo) {
        setLevel(level);
        setBankTitles(bankTitles);
        setCreditInfo(creditInfo);
    }

    public BankInfo() {
        setLevel(-1);
        setBankTitles(null);
        setCreditInfo(null);
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        if(level >= 0) {
            this.level = level;
        }
        else {
            this.level = 400;
        }
    }

    public String[] getBankTitles() {
        String[] toReturn = new String[bankTitles.length];
        for (int i = 0; i < bankTitles.length; i++) {
            toReturn[i] = bankTitles[i];
        }
        return toReturn;
    }

    public void setBankTitles(String[] bankTitles) {
        if(bankTitles == null) {
            this.bankTitles = new String[]{"ПИ", "ОБ", "РФ", "АБ", "HS"};
        }
        else {
            this.bankTitles = new String[bankTitles.length];
            for (int i = 0; i < bankTitles.length; i++) {
                this.bankTitles[i] = bankTitles[i];
            }
        }
    }

    public Map<Integer, Map<Integer, Double>> getCreditInfo() {
        return new TreeMap<>(creditInfo);
    }

    public void setCreditInfo(Map<Integer, Map<Integer, Double>> creditInfo) {
        if(creditInfo != null) {
            this.creditInfo = new TreeMap<>(creditInfo);
        }
        else {
            this.creditInfo = new TreeMap<>();
        }
    }

    @Override
    public String toString() {
        return "BankInfo{" +
                "level=" + level +
                ", bankTitles=" + Arrays.toString(bankTitles) +
                ", creditInfo=" + creditInfo +
                '}';
    }
}
