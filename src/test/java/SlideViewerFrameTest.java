import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.WindowEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlideViewerFrameTest {

    @Test
    void testSlideViewerFrame() {
        SwingUtilities.invokeLater(() -> {
            // Create some slides for testing
            Slide slide1 = new Slide();
            slide1.setTitle("Slide 1 Title");
            slide1.append(0, "Slide 1 Content");

            Slide slide2 = new Slide();
            slide2.setTitle("Slide 2 Title");
            slide2.append(0, "Slide 2 Content");

            // Create a presentation
            Presentation presentation = new Presentation();
            presentation.setTitle("Presentation Title");
            presentation.append(slide1);
            presentation.append(slide2);

            // Create a SlideViewerFrame
            SlideViewerFrame frame = new SlideViewerFrame("Test Slide Viewer", presentation);

            // Get the content pane of the frame
            JComponent contentPane = (JComponent) frame.getContentPane();

            // Check the title of the frame
            assertEquals("Test Slide Viewer", frame.getTitle());

            // Check if the content pane contains SlideViewerComponent
            assertTrue(contentPane.getComponent(0) instanceof SlideViewerComponent);

            // Check if the frame size matches the expected dimensions
            assertEquals(SlideViewerFrame.WIDTH, frame.getSize().width);
            assertEquals(SlideViewerFrame.HEIGHT, frame.getSize().height);

            // Close the frame after testing
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }
}
