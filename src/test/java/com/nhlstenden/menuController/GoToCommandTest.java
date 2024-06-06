package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GoToCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"}) // Add more page numbers as needed
    public void testExecute(String pageNumberInput) {
        Presentation presentationMock = mock(Presentation.class);

        // Prepare input for JOptionPane
        String input = pageNumberInput; // Simulating the user entering the page number
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream); // Redirect System.in to our ByteArrayInputStream

        GoToCommand goToCommand = new GoToCommand(presentationMock);
        goToCommand.execute();

        // Calculate the expected slide number based on the user input
        int expectedSlideNumber = Integer.parseInt(pageNumberInput) - 1;

        // Verify that the slide number is set correctly
        verify(presentationMock, times(1)).setSlideNumber(expectedSlideNumber);
    }
}
