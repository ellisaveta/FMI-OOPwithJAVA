package cipher.demomidtermfx;

import java.net.URL;
import java.util.ResourceBundle;

import Cipher.Encryption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CipherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDecrypt;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtCipherText;

    @FXML
    private TextField txtKey;

    @FXML
    private TextField txtPlainText;

    @FXML
    void btnDecryptOnAction(ActionEvent event) {
        TestMethod testMethod = new TestMethod(new Encryption());
        if(txtKey.getText() != null && txtCipherText.getText() != null) {
            txtPlainText.setText(testMethod.method.decryptText(txtCipherText.getText(), txtKey.getText()));
        }
    }

    @FXML
    void btnEncryptOnAction(ActionEvent event) {
        TestMethod testMethod = new TestMethod(new Encryption());
        if(txtKey.getText() != null && txtPlainText.getText() != null) {
            txtCipherText.setText(testMethod.method.encryptText(txtPlainText.getText(), txtKey.getText()));
        }
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {
        assert btnDecrypt != null : "fx:id=\"btnDecrypt\" was not injected: check your FXML file 'cipher-view.fxml'.";
        assert btnEncrypt != null : "fx:id=\"btnEncrypt\" was not injected: check your FXML file 'cipher-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'cipher-view.fxml'.";
        assert txtCipherText != null : "fx:id=\"txtCipherText\" was not injected: check your FXML file 'cipher-view.fxml'.";
        assert txtKey != null : "fx:id=\"txtKey\" was not injected: check your FXML file 'cipher-view.fxml'.";
        assert txtPlainText != null : "fx:id=\"txtPlainText\" was not injected: check your FXML file 'cipher-view.fxml'.";

    }

}
