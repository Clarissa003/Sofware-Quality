import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.WindowEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlideViewerFrameTest
{

    @Test
    void testSlideViewerFrame()
    {
        SwingUtilities.invokeLater(() ->
        {
            Slide slide1 = new Slide();
            slide1.setTitle("Slide 1 Title");
            slide1.append(0, "Slide 1 Content");

            Slide slide2 = new Slide();
            slide2.setTitle("Slide 2 Title");
            slide2.append(0, "Slide 2 Content");

            Presentation presentation = new Presentation();
            presentation.setTitle("Presentation Title");
            presentation.append(slide1);
            presentation.append(slide2);

            SlideViewerFrame frame = new SlideViewerFrame("Test Slide Viewer", presentation);

            JComponent contentPane = (JComponent) frame.getContentPane();

            assertEquals("Test Slide Viewer", frame.getTitle());

            assertTrue(contentPane.getComponent(0) instanceof SlideViewerComponent);

            assertEquals(SlideViewerFrame.WIDTH, frame.getSize().width);
            assertEquals(SlideViewerFrame.HEIGHT, frame.getSize().height);

            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }
}
