package model.com;

import java.io.Serializable;

public class TradeProduct implements Serializable, ITradeService {
    private Currency[] moneyToTrade;

    public TradeProduct() {
        setMoneyToTrade(null);
    }

    public synchronized Currency[] getMoneyToTrade() {
        Currency[] toReturn  = new Currency[moneyToTrade.length];
        for (int i = 0; i < moneyToTrade.length; i++) {
            toReturn[i] = moneyToTrade[i];
        }
        return toReturn;
    }

    public synchronized void setMoneyToTrade(Currency[] moneyToTrade) {
        if(moneyToTrade != null) {
            this.moneyToTrade = new Currency[moneyToTrade.length];
            for (int i = 0; i < moneyToTrade.length; i++) {
                this.moneyToTrade[i] = moneyToTrade[i];
            }
        }
        else {
            this.moneyToTrade = new Currency[4];
            Currency curr1;
            Money money1 = Money.EUR_USD;
            curr1 = new Currency(money1, 1.130);
            Currency curr2;
            Money money2 = Money.GBP_USD;
            curr2 = new Currency(money2, 1.65);
            Currency curr3;
            Money money3 = Money.USD_JPY;
            curr3 = new Currency(money3, 107.102);
            Currency curr4;
            Money money4 = Money.USD_RUB;
            curr4 = new Currency(money4, 34.37);

            this.moneyToTrade[0] = curr1;
            this.moneyToTrade[1] = curr2;
            this.moneyToTrade[2] = curr3;
            this.moneyToTrade[3] = curr4;

        }
    }

    @Override
    public Currency[] getTrade() {
        return getMoneyToTrade();
    }
}
