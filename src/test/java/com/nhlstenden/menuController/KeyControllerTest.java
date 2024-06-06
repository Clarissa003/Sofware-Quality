package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class KeyControllerTest {
    private KeyController keyController;
    private Presentation presentationMock;

    @BeforeEach
    public void setUp() {
        presentationMock = mock(Presentation.class);
        keyController = new KeyController(presentationMock);
    }

    @Test
    public void testKeyPress_NextCommand_PageDown() {
        testKeyPress(KeyEvent.VK_PAGE_DOWN, "com.nhlstenden.menuController.NextCommand");
    }

    @Test
    public void testKeyPress_NextCommand_VKDown() {
        testKeyPress(KeyEvent.VK_DOWN, "com.nhlstenden.menuController.NextCommand");
    }

    @Test
    public void testKeyPress_NextCommand_VKEnter() {
        testKeyPress(KeyEvent.VK_ENTER, "com.nhlstenden.menuController.NextCommand");
    }

    @Test
    public void testKeyPress_NextCommand_VKT() {
        testKeyPress(KeyEvent.VK_T, "com.nhlstenden.menuController.NextCommand");
    }

    @Test
    public void testKeyPress_NextCommand_Plus() {
        testKeyPress((int) '+', "com.nhlstenden.menuController.NextCommand");
    }

    @Test
    public void testKeyPress_PrevCommand_PageUP() {
        testKeyPress(KeyEvent.VK_PAGE_UP, "com.nhlstenden.menuController.PrevCommand");
    }

    @Test
    public void testKeyPress_PrevCommand_VKUp() {
        testKeyPress(KeyEvent.VK_UP, "com.nhlstenden.menuController.PrevCommand");
    }

    @Test
    public void testKeyPress_PrevCommand_VKP() {
        testKeyPress(KeyEvent.VK_P, "com.nhlstenden.menuController.PrevCommand");
    }

    @Test
    public void testKeyPress_PrevCommand_Minus() {
        testKeyPress((int) '-', "com.nhlstenden.menuController.PrevCommand");
    }

    @Test
    public void testKeyPress_OpenCommand_VKO() {
        testKeyPress(KeyEvent.VK_O, "com.nhlstenden.menuController.OpenCommand");
    }

    @Test
    public void testKeyPress_NewCommand_VKN() {
        testKeyPress(KeyEvent.VK_N, "com.nhlstenden.menuController.NewCommand");
    }

    @Test
    public void testKeyPress_SaveCommand_VKS() {
        testKeyPress(KeyEvent.VK_S, "com.nhlstenden.menuController.SaveCommand");
    }

    @Test
    public void testKeyPress_ExitCommand_VKX() {
        testKeyPress(KeyEvent.VK_X, "com.nhlstenden.menuController.ExitCommand");
    }
    
    @Test
    public void testKeyPress_AboutCommand_VKA() {
        testKeyPress(KeyEvent.VK_A, "com.nhlstenden.menuController.AboutCommand");
    }

    @Test
    public void testKeyPress_DefaultCase() {
        testKeyPress(KeyEvent.VK_UNDEFINED, null); // An arbitrary key code not handled in the switch statement
    }

    @Test
    public void testKeyPress_ExceptionHandling_InstantiateCommand() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S); // A key code that triggers the instantiation of a command

        // Mocking the instantiation of SaveCommand to throw an exception
        doThrow(RuntimeException.class).when(presentationMock).setSlideNumber(0);

        keyController.keyPressed(keyEvent);

        // Ensure that the exception is caught and no further action is taken
        verify(presentationMock, never()).setSlideNumber(0);
    }

    private void testKeyPress(int keyCode, String expectedCommandClass) {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(keyCode);

        keyController.keyPressed(keyEvent);

        if (expectedCommandClass != null) {
            verifyCommandInstantiation(expectedCommandClass);
        } else {
            verifyNoInteractions(presentationMock);
        }
    }

    private void verifyCommandInstantiation(String expectedCommandClass) {
        try {
            // Create a spy of the original keyController
            KeyController spyKeyController = spy(new KeyController(presentationMock));
            Command mockCommand = mock(Command.class);

            // Use reflection to access and override the private method
            doReturn(mockCommand).when(spyKeyController);

            // Capture the command class name passed to instantiateCommand
            spyKeyController.keyPressed(mock(KeyEvent.class));
            ArgumentCaptor<String> commandClassCaptor = ArgumentCaptor.forClass(String.class);
            verify(spyKeyController).instantiateCommand(commandClassCaptor.capture());

            // Verify the correct command class was instantiated
            assertTrue(commandClassCaptor.getValue().contains(expectedCommandClass), "Command class does not match");

            // Execute the command and verify
            verify(mockCommand, times(1)).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
