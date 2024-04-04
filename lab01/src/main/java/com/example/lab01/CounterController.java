package com.example.lab01;



import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Controller class for the Counter application.
 */

public class CounterController {
    private Counter model;
    private CounterView view;
    private Stage stage;

    /**
     * Constructor for CounterController with model and view.
     * @param model The Counter model.
     * @param view The CounterView.
     */

    public CounterController(Counter model, CounterView view) {
        this.model = model;
        this.view = view;

        view.textInput.setOnKeyReleased(event -> processInput(view.textInput.getText()));
    }
    /**
     * Constructor for CounterController with a stage.
     * @param stage The JavaFX stage.
     */

    public CounterController(Stage stage) {
        this.stage = stage;
        this.model = new Counter();
        this.view = new CounterView(stage);


        view.lineCountLabel.setText("  Number of lines:  0");
        view.wordCountLabel.setText("  Number of words:  0");
        view.charCountLabel.setText("  Number of chars:  0");
        view.digitCountLabel.setText("  Number of digits:  0");

        view.textInput.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    processInput(view.textInput.getText());
                }
            }
        });
    }
    /**
     * Default constructor for CounterController.
     */
    public CounterController() {
    //EMPTY CONSTRUCTOR
    }
    /**
     * Process the input text and update the view with count information.
     * @param text The input text to process.
     */
    public void processInput(String text) {
        int lineCount = model.countLines(text);
        int wordCount = model.countWords(text);
        int charCount = model.countCharacters(text);
        int digitCount = model.countDigits(text);

        view.lineCountLabel.setText("  Number of lines:  " + lineCount);
        view.wordCountLabel.setText("  Number of words:  " + wordCount);
        view.charCountLabel.setText("  Number of chars:  " + charCount);
        view.digitCountLabel.setText("  Number of digits:  " + digitCount);
    }
    /**
     * Count the number of lines in the given text.
     * @param text The text to count lines from.
     * @return The number of lines.
     */

    public int countLines(String text) {
        return text.split("\\r?\\n").length;
    }
    /**
     * Count the number of lines in the given text.
     * @param text The text to count WORDS from.
     * @return The number of WORDS.
     */

    public int countWords(String text) {
        return text.isEmpty() ? 0 : text.trim().split("\\s+").length;
    }
    /**
     * Count the number of lines in the given text.
     * @param text The text to count CHARACTERS from.
     * @return The number of CHARACTERS.
     */

    public int countCharacters(String text) {
        return text.length();
    }
    /**
     * Count the number of lines in the given text.
     * @param text The text to count DIGITS from.
     * @return The number of DIGITS.
     */


    public int countDigits(String text) {
        return text.replaceAll("[^0-9]", "").length();
    }
}
