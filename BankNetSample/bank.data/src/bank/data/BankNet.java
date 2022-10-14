package bank.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BankNet {
    private double[][] credits;
    private double safeLevel;
    private Function<Integer, String> mapToName;

    public BankNet(int numOfBanks, double safeLevel, Function<Integer, String> mapToName) {
        credits = new double[numOfBanks][numOfBanks];
        setSafeLevel(safeLevel);
        setMapToName(mapToName);
    }

    public double getSafeLevel() {
        return safeLevel;
    }

    public void setSafeLevel(double safeLevel) {
        if(safeLevel >= 0) {
            this.safeLevel = safeLevel;
        }
        else {
            this.safeLevel = 500;
        }
    }

    public Function<Integer, String> getMapToName() {
        return mapToName;
    }

    public void setMapToName(Function<Integer, String> mapToName) {
        if(mapToName == null) {
            this.mapToName = e -> "Bank";
        }
        else {
            this.mapToName = mapToName;
        }
    }

    public boolean hasGivenCredit(int i, int j) {
        return credits[i][j] > 0;
    }

    public void setCredit(int i, int j, double credit) {
        credits[i][j] = credit;
    }

    public double getCredit (int i, int j) {
        return credits[i][j];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("Въведени банки\nНиво на надеждност: %.2f\n", safeLevel));

        for (int i = 0; i < credits.length; i++) {
            for (int j = 0; j < credits[i].length; j++) {
                if(credits[i][j] > 0) {
                    result.append(String.format("%s<- %.2f ->%s\n", mapToName.apply(i), credits[i][j], mapToName.apply(j)));
                }
            }
        }
        return result.toString();
    }

    public boolean isSafeBank(int i) {
        double capital = 0.0;
        for (int j = 0; j < credits[i].length; j++) {
            capital += credits[i][j];
        }

        double creditsTaken = 0.0;
        for (int j = 0; j < credits.length; j++) {
            if(j != i) {
                creditsTaken += credits[j][i];
            }
        }

        return capital > safeLevel && creditsTaken < 0.85 * capital;
    }

    public void invalidateCredits(int i, double[][] transactions) {
        for (int j = 0; j < transactions.length; j++) {
            if(j != i) {
                transactions[j][i] = 0.0;
            }
        }
    }

    public List<String> findUnsafebanks() {
        double[][] updatedCredits = new double[credits.length][credits.length];
        List<Integer> unsafeBanksNumbers = new ArrayList<>();
        for (int i = 0; i < credits.length; i++) {
            if(!unsafeBanksNumbers.contains(i) && !isSafeBank(i)) {
                unsafeBanksNumbers.add(i);
                for (int j = 0; j < credits.length; j++) {
                    for (int k = 0; k < credits[j].length; k++) {
                        updatedCredits[j][k] = credits[j][k];
                    }
                }
                invalidateCredits(i, updatedCredits);
                for (int j = 0; j < updatedCredits.length; j++) {
                    for (int k = 0; k < updatedCredits[j].length; k++) {
                        credits[j][k] = updatedCredits[j][k];
                    }
                }
            }
        }

        List<String> unsafeBanksNames = unsafeBanksNumbers.stream()
                .map(mapToName)
                .sorted(Comparator.reverseOrder())
                .toList();

        return  unsafeBanksNames;
    }
}
