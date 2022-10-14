package time;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Clock extends Pane {
    private Time time;

    private Button btnStart = new Button("Start");
    private Button btnStop = new Button("Stop");
    private Label lblClockDisplay = new Label();
    private HBox hBox = new HBox();
    private VBox vBox = new VBox();

    private Thread timerThread;

    public Clock() throws InterruptedException {
        super();
        time = new Time();

        btnStart.setOnAction(e -> start());
        btnStop.setOnAction(e -> stop());

        hBox.getChildren().add(btnStart);
        hBox.getChildren().add(btnStop);

        vBox.getChildren().add(lblClockDisplay);
        vBox.getChildren().add(hBox);

        this.getChildren().add(vBox);

        setupTimer();
    }

    private void start() {
        time.setCurrentTime();

        try {
            setupTimer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void stop(){
        timerThread.stop();
    }

    private void updateTimer(){
        Platform.runLater(() -> {
            lblClockDisplay.setText(time.toString());
        });
    }

    private void setupTimer() throws InterruptedException {
        timerThread = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    time.tickSeconds();
                    updateTimer();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        timerThread.join();
        timerThread.start();
    }

    public void setClock(Time time){
        time.setTime(time);
    }
}
