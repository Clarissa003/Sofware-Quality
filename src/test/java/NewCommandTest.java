import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NewCommandTest {

    @Test
    public void testExecute() {
        Presentation presentationMock = mock(Presentation.class);
        MenuController menuControllerMock = mock(MenuController.class);

        NewCommand newCommand = new NewCommand(presentationMock, menuControllerMock);
        newCommand.execute();

        verify(presentationMock, times(1)).clear();
        verify(menuControllerMock, times(1)).setNewSlideRequested(true);
        verify(menuControllerMock, times(1)).showCreateSlideDialog();
    }
}
