package model.com;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.function.Supplier;

public class StockExchangeController  implements Runnable {
    private TextArea txaExchange;
    private Currency[] currency;
    private String txtUpdate;
    public  Supplier<Currency[]>  traders;


    public StockExchangeController(TextArea txaExchange) {
        this.txaExchange = txaExchange;
    }

    @Override
    public void run() {
        while(true) {
            currency = traders.get();
            try {
                Thread.sleep(1000);
                Platform.runLater(() -> {
                    StringBuilder sb = new StringBuilder();
                    for(Currency curr : currency) {
                        sb.append(curr.toString()).append('\n');
                    }
                    txaExchange.setText(sb.toString());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTraders() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
