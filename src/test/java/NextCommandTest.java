import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NextCommandTest {

    @Test
    public void testExecute() {
        // Create a mock Presentation object
        Presentation presentationMock = mock(Presentation.class);

        // Create a NextCommand instance with the mock Presentation
        NextCommand nextCommand = new NextCommand(presentationMock);

        // Call execute method
        nextCommand.execute();

        // Verify that presentation.nextSlide() method was called exactly once
        verify(presentationMock, times(1)).nextSlide();
    }
}
