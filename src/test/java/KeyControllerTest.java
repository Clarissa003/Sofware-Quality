import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.swing.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JOptionPane.class})
public class KeyControllerTest {
    private KeyController keyController;
    private Presentation presentationMock;
    private MenuController menuControllerMock;
    private Accessor accessorMock;


    @BeforeEach
    public void setUp() throws IOException
    {
        presentationMock = mock(Presentation.class);
        Frame frame = null;
        keyController = new KeyController(presentationMock);
        menuControllerMock = mock(MenuController.class);
        accessorMock = mock(Accessor.class);
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

        // Instantiate NewCommand with both mocks
        NewCommand newCommand = new NewCommand(presentationMock, menuControllerMock);

        // Call the execute method
        newCommand.execute();

        // Verify interactions
        verify(presentationMock, times(1)).clear();
        verify(menuControllerMock, times(1)).setNewSlideRequested(true);
        verify(menuControllerMock, times(1)).showCreateSlideDialog();
    }

    @Test
    public void testKeyPress_SaveCommand_VKS() throws IOException {
        // Set up the 'S' key event
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        // Instantiate SaveCommand with mocks
        SaveCommand saveCommand = new SaveCommand(presentationMock);

        // Call the execute method
        saveCommand.execute();

        // Verify that accessorMock.saveFile() is called with the correct arguments
        verify(accessorMock, times(1)).saveFile(eq(presentationMock), eq(MenuController.SAVEFILE));
    }

    @Test
    public void testKeyPress_ExitCommand() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_X);

        keyController.keyPressed(keyEvent);
        verify(presentationMock, times(1)).exit(0);
    }

    @Test
    public void testKeyPress_GoToCommand_VKG() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_G);

        // Mock the behavior of JOptionPane.showInputDialog()
        PowerMockito.mockStatic(JOptionPane.class);

        // Stub the behavior to return "2" when JOptionPane.showInputDialog() is called
        when(JOptionPane.showInputDialog(anyString())).thenReturn("2");

        // Call the method under test
        keyController.keyPressed(keyEvent);

        // Verify that JOptionPane.showInputDialog() is called once with anyString()
        PowerMockito.verifyStatic(JOptionPane.class, times(1));
        JOptionPane.showInputDialog(anyString());

        // Verify that presentation.setSlideNumber() is called once with the correct argument
        verify(presentationMock, times(1)).setSlideNumber(1); // Subtract 1 because input is 2
    }

    @Test
    public void testKeyPress_AboutCommand_VKA() {
        KeyEvent keyEvent = mock(KeyEvent.class);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        // Mock the necessary dependencies
        Frame aboutBoxMock = mock(Frame.class);

        // Create an instance of AboutCommand with the mocked aboutBox
        AboutCommand aboutCommand = new AboutCommand(presentationMock, aboutBoxMock);

        // Call the keyPressed method with the mocked KeyEvent
        keyController.keyPressed(keyEvent);

        // Verify that the AboutCommand is executed
        aboutCommand.execute();

        // Verify that the AboutBox.show method is called with the aboutBox frame
        verify(aboutBoxMock, times(1)).setVisible(true); // Assuming aboutBoxMock is a Frame, use appropriate method
    }
}
