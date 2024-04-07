import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JabberPointTest {

    @Test
    public void testMain() {
        // Test if the main method runs without throwing an exception
        assertDoesNotThrow(() -> JabberPoint.main(new String[]{}));
    }
}
