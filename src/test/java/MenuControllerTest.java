import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import javax.swing.JOptionPane;
import static org.powermock.api.mockito.PowerMockito.whenNew;

public class MenuControllerTest {

    private Frame frameMock;
    private Presentation presentationMock;
    private Accessor accessorMock;
    private MenuController menuController;
    private JOptionPane optionPaneMock;

    @BeforeEach
    public void setUp() {
        frameMock = mock(Frame.class);
        presentationMock = mock(Presentation.class);
        accessorMock = mock(Accessor.class);
        optionPaneMock = mock(JOptionPane.class);
        menuController = new MenuController(frameMock, presentationMock, accessorMock);
        menuController.setOptionPane(optionPaneMock);
    }

    /*@Test
    public void testCreateMenuItem() {
        // Mocking command
        Command commandMock = mock(Command.class);

        // Create menu item
        MenuItem menuItem = menuController.createMenuItem("Test", commandMock, KeyEvent.VK_T);

        // Verify menu item creation
        assertNotNull(menuItem);
        assertEquals("Test", menuItem.getLabel());
        assertEquals(KeyEvent.VK_T, menuItem.getShortcut().getKey());

        // Simulate click action
        ActionListener[] actionListeners = menuItem.getActionListeners();
        assertEquals(1, actionListeners.length); // Ensure only one action listener is added
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Test");
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(actionEvent);
        }

        // Verify command execution
        verify(commandMock, times(1)).execute();

    }*/

    @Test
    public void testIsSlideCreationRequested_ExpectFalse() {
        assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testIsSlideCreationRequested_ExpectTrue() {
        menuController.setNewSlideRequested(true);
        assertTrue(menuController.isSlideCreationRequested());
    }

    @Test
    public void testClearSlideCreationRequest_ExpectTrue() {
        menuController.setNewSlideRequested(true);
        assertTrue(menuController.isSlideCreationRequested());
    }

    @Test
    public void testClearSlideCreationRequest_ExpectFalse() {
        menuController.clearSlideCreationRequest();
        assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testSetNewSlideRequested_ExpectFalse() {
        assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testSetNewSlideRequested_ExpectTrue() {
        assertFalse(menuController.isSlideCreationRequested());
        menuController.setNewSlideRequested(true);
        assertTrue(menuController.isSlideCreationRequested());
    }

    /*@Test
    public void testShowCreateSlideDialog() {
        // Mock user input for slide title and content
        when(JOptionPane.showInputDialog(eq(frameMock), eq("Enter slide title:"))).thenReturn("Title");
        when(JOptionPane.showInputDialog(eq(frameMock), eq("Enter slide content (empty line to finish):")))
                .thenReturn("Content1", "Content2", "");

        // Simulate showing create slide dialog
        menuController.showCreateSlideDialog();

        // Verify that the expected methods were called
        verify(presentationMock).append(any(Slide.class));
        verify(presentationMock).notifyObservers();
    }*/
}
