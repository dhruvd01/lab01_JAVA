package com.example.lab01;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        new CounterController(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
