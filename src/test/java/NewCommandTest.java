import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NewCommandTest {

    @Test
    public void testExecute() {
        // Create mock objects for Presentation and MenuController
        Presentation presentationMock = mock(Presentation.class);
        MenuController menuControllerMock = mock(MenuController.class);

        // Create a NewCommand instance with the mock objects
        NewCommand newCommand = new NewCommand(presentationMock, menuControllerMock);

        // Call execute method
        newCommand.execute();

        // Verify that presentation.clear() method was called exactly once
        verify(presentationMock, times(1)).clear();

        // Verify that menuController.setNewSlideRequested(true) method was called exactly once
        verify(menuControllerMock, times(1)).setNewSlideRequested(true);

        // Verify that menuController.showCreateSlideDialog() method was called exactly once
        verify(menuControllerMock, times(1)).showCreateSlideDialog();
    }

    // Add more tests as needed
}
