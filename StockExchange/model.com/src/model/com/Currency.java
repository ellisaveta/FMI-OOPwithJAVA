package model.com;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

public class Currency implements Serializable {
    private Money currencyCode;
    private double exchange;
    private static Random rand;

    public Currency(Money currencyCode, double exchange) {
        setCurrencyCode(currencyCode);
        setExchange(exchange);
    }

    public Currency(Currency other) {
        setCurrencyCode(other.getCurrencyCode());
        setExchange(other.getExchange());
    }

    public Money getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Money currencyCode) {
        if(currencyCode != null)
            this.currencyCode = currencyCode;
        else
            this.currencyCode = Money.EUR_USD;
    }

    public double getExchange() {
        return exchange;
    }

    public void setExchange(double exchange) {
        if(exchange <= 0)
            this.exchange = 1.0;
        else
            this.exchange = exchange;
    }

    @Override
    public String toString() {
        return String.format("%s %.4f %s", currencyCode.name(), exchange, LocalTime.now().toString());
    }

    public void changeExchangeRate() {
        double random = rand.nextDouble();
        double temp = -0.03 + (random * (0.03 - (-0.03)));
        temp = Double.parseDouble(String.format("%.4f", temp));
        exchange +=   temp * exchange;
        exchange = Double.parseDouble(String.format("%.4f", exchange));
    }
}
