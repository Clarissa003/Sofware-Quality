import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PrevCommandTest {

    @Test
    public void testExecute() {
        // Create a mock Presentation object
        Presentation presentationMock = mock(Presentation.class);

        // Create a PrevCommand instance with the mock Presentation
        PrevCommand prevCommand = new PrevCommand(presentationMock);

        // Call execute method
        prevCommand.execute();

        // Verify that presentation.prevSlide() method was called exactly once
        verify(presentationMock, times(1)).prevSlide();
    }
}
