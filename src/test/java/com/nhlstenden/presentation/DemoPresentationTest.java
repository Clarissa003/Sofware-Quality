package com.nhlstenden.presentation;

import com.nhlstenden.slide.BitmapItem;
import com.nhlstenden.slide.Slide;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoPresentationTest {

    private DemoPresentation demoPresentation;
    private Presentation presentation;

    @Before
    public void setUp() {
        demoPresentation = new DemoPresentation();
        presentation = new Presentation();
    }

    @Test
    public void testLoadFile() {
        demoPresentation.loadFile(presentation, "");

        assertEquals("Demo com.nhlstenden.presentation.Presentation", presentation.getTitle());

        assertEquals(3, presentation.getSize());

        Slide firstSlide = presentation.getSlide(0);
        assertEquals("JabberPoint", firstSlide.getTitle());
        assertEquals(10, firstSlide.getSlideItems().size());

        Slide secondSlide = presentation.getSlide(1);
        assertEquals("Demonstration of levels and stijlen", secondSlide.getTitle());
        assertEquals(7, secondSlide.getSlideItems().size());

        Slide thirdSlide = presentation.getSlide(2);
        assertEquals("The third slide", thirdSlide.getTitle());
        assertEquals(5, thirdSlide.getSlideItems().size());
        assertTrue(thirdSlide.getSlideItems().get(4) instanceof BitmapItem);
        BitmapItem bitmapItem = (BitmapItem) thirdSlide.getSlideItems().get(4);
        assertEquals("JabberPoint.jpg", bitmapItem.getName());
    }

    @Test(expected = IllegalStateException.class)
    public void testSaveFile() {
        demoPresentation.saveFile(presentation, "");
    }
}

