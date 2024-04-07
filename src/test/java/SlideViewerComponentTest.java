import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.*;
import javax.swing.JFrame;

public class SlideViewerComponentTest
{

    private Presentation presentation;
    private Slide slide;
    private SlideViewerComponent slideViewerComponent;
    private JFrame mockFrame;

    @BeforeEach
    void setUp ()
    {
        presentation = mock (Presentation.class);
        slide = new Slide ();

        mockFrame = mock (JFrame.class);
        slideViewerComponent = new SlideViewerComponent (presentation, mockFrame);
    }

    @Test
    void testPreferredSize()
    {
        Dimension expected = new Dimension(Slide.WIDTH, Slide.HEIGHT);
        assertEquals(expected, slideViewerComponent.getPreferredSize());
    }

    @Test
    void testUpdate()
    {
        when (presentation.getCurrentSlide()).thenReturn(slide);

        slideViewerComponent.update(presentation, slide);

        assertSame(slide, slideViewerComponent.slide);
    }

    @Test
    void testSlideViewerComponent()
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

        JFrame frame = Mockito.mock(JFrame.class);

        Graphics graphics = Mockito.mock(Graphics.class);
        Mockito.when(frame.getGraphics()).thenReturn(graphics);

        SlideViewerComponent component = new SlideViewerComponent(presentation, frame);

        Mockito.when(frame.getTitle()).thenReturn("Presentation Title");

        component.update(presentation, slide1);

        assertEquals("Presentation Title", frame.getTitle());

        assertDoesNotThrow(() -> component.paintComponent(graphics));
    }
}


