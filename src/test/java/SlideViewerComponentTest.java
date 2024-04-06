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

        // Create a mock JFrame
        mockFrame = mock (JFrame.class);
        slideViewerComponent = new SlideViewerComponent (presentation, mockFrame);
    }

    @Test
    void testPreferredSize ()
    {
        Dimension expected = new Dimension (Slide.WIDTH, Slide.HEIGHT);
        assertEquals (expected, slideViewerComponent.getPreferredSize ());
    }

    @Test
    void testUpdate ()
    {
        when (presentation.getCurrentSlide ()).thenReturn (slide);

        slideViewerComponent.update (presentation, slide);

        // Verify that the slide field is set correctly
        assertSame (slide, slideViewerComponent.slide);
    }
}
   /* @Test
    void testSlideViewerComponent() {
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

        // Create a JFrame for testing
        JFrame frame = new JFrame("Slide Viewer Test");
        SlideViewerComponent component = new SlideViewerComponent(presentation, frame);

        // Set up the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);

        // Call update to trigger repaint and set the title
        component.update(presentation, slide1);

        // Verify the title of the JFrame
        assertEquals("Presentation Title", frame.getTitle());

        // We cannot verify the exact content of the graphics in a unit test,
        // but we can verify that the component was painted without exceptions
        assertDoesNotThrow(() -> {
            Graphics g = component.getGraphics();
            component.paintComponent(g);
        });

        // Close the frame after testing
        frame.setVisible(false);
        frame.dispose();
    }*/

   /* @Test
    void testPaintComponent() {
        // Create a mock Graphics object
        Graphics graphics = mock(Graphics.class);

        // Mock the behavior for getSlideNumber and getSize
        when(presentation.getSlideNumber()).thenReturn(0);
        when(presentation.getSize()).thenReturn(1);

        // Call the method to be tested
        slideViewerComponent.paintComponent(graphics);

        // Verify that the background is filled with BGCOLOR (Color.WHITE)
        verify(graphics).setColor(Color.white);
        verify(graphics).fillRect(0, 0, slideViewerComponent.getWidth(), slideViewerComponent.getHeight());

        // Verify that the slide information is drawn in COLOR (Color.BLACK)
        verify(graphics).setColor(Color.black);
        verify(graphics).setFont(slideViewerComponent.getFont());
        verify(graphics).drawString("Slide 1 of 1", slideViewerComponent.getX (), slideViewerComponent.getY ());

        // Verify that the slide is drawn
        verify(slide).draw(eq(graphics), any(Rectangle.class), any(SlideViewerComponent.class));
    }*/


