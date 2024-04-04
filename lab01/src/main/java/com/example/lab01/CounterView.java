package com.example.lab01;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class CounterView {
    public TextArea textInput;
    public Label lineCountLabel;
    public Label wordCountLabel;
    public Label charCountLabel;
    public Label digitCountLabel;
    private ToolBar statusBar;

    public CounterView(Stage stage) {
        textInput = new TextArea();
        textInput.setPrefRowCount(20);
        textInput.setPrefColumnCount(50);

        statusBar = new ToolBar();
        createStatusBar();

        Button countButton = new Button("Process the text");

        lineCountLabel = new Label("  Number of lines:");
        lineCountLabel.setMaxWidth(1000);

        wordCountLabel = new Label();
        charCountLabel = new Label();
        digitCountLabel = new Label();

        VBox root = new VBox(6, statusBar, textInput, countButton, lineCountLabel, wordCountLabel, charCountLabel, digitCountLabel);
        root.setStyle("-fx-background-color: lightgrey; -fx-border-color: grey; -fx-border-width:5px");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MicrosoftWord/Word/Char/digit Counter");
        stage.setResizable(false);
        stage.show();
    }

    private void createStatusBar() {
        Label statusLabel = new Label("Type your text here");
        Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.ALWAYS);
        Label exitLabel = new Label("Press Esc to Exit");

        statusBar.getItems().addAll(statusLabel, pane, exitLabel);
    }

}
