package com.example.lab01;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
/**
 * Counter class representing a JavaFX application for counting various text properties.
 */
public class Counter extends Application {
    private Counter model; // Model
    private CounterController Controller; // Controller
     public TextArea textInput;     // For the user's input text.
    public Label lineCountLabel;
    public Label wordCountLabel;
    public Label charCountLabel;
    public Label digitCountLabel;
    private ToolBar statusBar;

    /**
     * The main method to launch the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method to initialize and layout the JavaFX components.
     */


    public int countLines(String text) {
        // Your implementation to count lines in the given text

        return text.split("\\r?\\n").length;
    }
    public int countWords(String text) {
        // Your implementation to count words in the given text

        return text.isEmpty() ? 0 : text.trim().split("\\s+").length;
    }
    public int countCharacters(String text) {
        // Your implementation to count characters in the given text

        return text.length();
    }

    // Define the countDigits() method
    public int countDigits(String text) {
        // Your implementation to count digits in the given text

        return text.replaceAll("[^0-9]", "").length();
    }

    @Override
    public void start(Stage stage) {
        model = new Counter();
        Controller = new CounterController();

        textInput = new TextArea();
        textInput.setPrefRowCount(20);
        textInput.setPrefColumnCount(50);

        statusBar = new ToolBar();
        createStatusBar();

        Button countButton = new Button("Process the text");
        countButton.setOnAction(e -> processInput());
        countButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        lineCountLabel = new Label("  Number of lines:");
        lineCountLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
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

        // Close the application when the escape key is pressed
        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    stage.hide();
                }
            }
        });
    }

    /**
     * Method to create the status bar components.
     */
    private void createStatusBar() {
        Label statusLabel = new Label("Type your text here");
        statusLabel.setStyle("-fx-text-fill: black; -fx-font: bold  12pt serif;-fx-padding: 4px;");
        Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.ALWAYS);
        Label exitLabel = new Label("Press Esc to Exit");

        statusBar.getItems().addAll(statusLabel, pane, exitLabel);
    }

    /**
     * Method to process the input text and update the counts.
     */
    public void processInput() {
        String text = textInput.getText();

        int charCount = text.length();
        int wordCount = text.isEmpty() ? 0 : text.trim().split("\\s+").length;
        int lineCount = text.isEmpty() ? 0 : text.split("\\r?\\n").length;
        int digitCount = text.replaceAll("[^0-9]", "").length();

        lineCountLabel.setText("  Number of lines:  " + lineCount);
        wordCountLabel.setText("  Number of words:  " + wordCount);
        charCountLabel.setText("  Number of chars:  " + charCount);
        digitCountLabel.setText("  Number of digits:  " + digitCount);
    }

    public int getLineCount() {

        return Integer.parseInt(lineCountLabel.getText().trim().split(":")[1].trim());
    }

    public int getWordCount() {
        return Integer.parseInt(wordCountLabel.getText().trim().split(":")[1].trim());
    }

    public int getCharCount() {
        return Integer.parseInt(charCountLabel.getText().trim().split(":")[1].trim());
    }

    public int getDigitCount() {

        return Integer.parseInt(digitCountLabel.getText().trim().split(":")[1].trim());
    }
    }


