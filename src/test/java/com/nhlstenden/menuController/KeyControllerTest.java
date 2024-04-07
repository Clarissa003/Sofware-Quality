package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JOptionPane.class})
public class KeyControllerTest {
    private KeyController keyController;
    private Presentation presentationMock;
    private MenuController menuControllerMock;


    @BeforeEach
    public void setUp() throws IOException
    {
        presentationMock = mock(Presentation.class);
        keyController = new KeyController(presentationMock);
        menuControllerMock = mock(MenuController.class);
        Accessor accessorMock = mock(Accessor.class);
        doThrow(new IOException("Test IOException"))
                .when(accessorMock)
                .saveFile(any(Presentation.class), eq(MenuController.SAVEFILE));

    }

    @Test
    public void testKeyPress_NextCommand_PageDown() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_DOWN);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).nextSlide();
    }

    @Test
    public void testKeyPress_NextCommand_VKDown() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).nextSlide();
    }

    @Test
    public void testKeyPress_NextCommand_VKEnter() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).nextSlide();
    }

    @Test
    public void testKeyPress_NextCommand_VKT() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_T);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).nextSlide();
    }

    @Test
    public void testKeyPress_PrevCommand_PageUP() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_UP);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).prevSlide();
    }

    @Test
    public void testKeyPress_PrevCommand_VKUp() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).prevSlide();
    }

    @Test
    public void testKeyPress_PrevCommand_VKP() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_P);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).prevSlide();
    }

    @Test
    public void testKeyPress_OpenCommand_VKO() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_O);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).setSlideNumber(0);
    }

    @Test
    public void testKeyPress_NewCommand_VKN() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_N);

        // Instantiate com.nhlstenden.menuController.NewCommand with both mocks
        NewCommand newCommand = new NewCommand(presentationMock, menuControllerMock);

        // Call the execute method
        newCommand.execute();

        // Verify interactions
        verify(presentationMock, times(1)).clear();
        verify(menuControllerMock, times(1)).setNewSlideRequested(true);
        verify(menuControllerMock, times(1)).showCreateSlideDialog();
    }

    @Test
    public void testKeyPress_ExitCommand() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_X);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).exit(0);
    }

}
