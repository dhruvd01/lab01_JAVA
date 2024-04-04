package com.example.lab01;

import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {
    private Counter model;
    private CounterController controller;
    private CounterView view;


    @BeforeEach
    public void setUp() {
        model = new Counter();
        controller = new CounterController(new Stage());
        view= new CounterView(new Stage());
        controller.processInput("Sample text for testing.");
    }

    @Test
    public void testProcessInput_NormalInput() {
        String inputText = "This is a normal input text.";

        controller.processInput(inputText);

        assertEquals(1, model.getLineCount());
        assertEquals(6, model.getWordCount());
        assertEquals(26, model.getCharCount());
        assertEquals(0, model.getDigitCount());
    }

    @Test
    public void testProcessInput_EmptyInput() {
        String inputText = "";

        controller.processInput(inputText);

        assertEquals(0, model.getLineCount());
        assertEquals(0, model.getWordCount());
        assertEquals(0, model.getCharCount());
        assertEquals(0, model.getDigitCount());
    }

    @Test
    public void testProcessInput_EdgeCase1() {
        // Test with input containing digits
        String inputText = "123 456 789";

        controller.processInput(inputText);

        assertEquals(1, model.getLineCount());
        assertEquals(3, model.getWordCount());
        assertEquals(11, model.getCharCount());
        assertEquals(9, model.getDigitCount());
    }

    @Test
    public void testProcessInput_EdgeCase2() {
        // Test with input containing special characters
        String inputText = "!@#$%^&*()";

        controller.processInput(inputText);

        assertEquals(1, model.getLineCount());
        assertEquals(1, model.getWordCount()); // Each special character is considered a separate word
        assertEquals(10, model.getCharCount());
        assertEquals(0, model.getDigitCount());
    }
}
