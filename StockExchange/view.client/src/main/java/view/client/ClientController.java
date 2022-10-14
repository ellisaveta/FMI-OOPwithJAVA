package view.client;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.com.Currency;
import model.com.ITradeService;
import model.com.StockExchangeController;

public class ClientController {

    private StockExchangeController controller;
    private ITradeService trade;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txaOutput;

    @FXML
    void initialize() {
        assert txaOutput != null : "fx:id=\"txaOutput\" was not injected: check your FXML file 'client-view.fxml'.";
        controller = new StockExchangeController(txaOutput);
        controller.traders = this::updateCurrency;
        readTrade();
        controller.onTraders();
    }

    Currency[] updateCurrency() {
        return trade.getTrade();
    }

    void readTrade() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 12345);
            trade = (ITradeService) registry.lookup("stock");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
