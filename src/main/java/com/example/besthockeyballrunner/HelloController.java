package com.example.besthockeyballrunner;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Label elapsedTime = new Label("00:00:00.00");

    private long startTime;
    private int player1GateCount;
    private int player2GateCount;
    @FXML
    private Label player1Winner;
    @FXML
    private Label player2Winner;


    @FXML
    protected void onButtonClick() {

        startTime = 0;
        player1GateCount = player2GateCount = 0;
        timer.start();
        startTime = System.nanoTime();
    }

    @FXML
    protected void onButtonStopClick() {
        timer.stop();
    }

    @FXML
    protected void onGate1Click() {
        player1GateCount++;
    }

    @FXML
    protected void onGate2Click() {
        player2GateCount++;
    }


    AnimationTimer timer = new AnimationTimer() {


        @Override
        public void handle(long currentTime) {
            if(startTime == 0){
                return;
            }
            long elapsedTime2 = (currentTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
            long hours = elapsedTime2 / 3600000;
            long minutes = (elapsedTime2 % 3600000) / 60000;
            long seconds = (elapsedTime2 % 60000) / 1000;
            long milliseconds = elapsedTime2 % 1000;

            String timeString = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
            elapsedTime.setText(timeString);
            if(player1GateCount >= 3 || player2GateCount >= 3){
                timer.stop();

            }
        }
    };



}