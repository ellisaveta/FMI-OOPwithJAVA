package cipher.demomidtermfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CipherApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CipherApplication.class.getResource("cipher-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Midterm Exam Sample");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}