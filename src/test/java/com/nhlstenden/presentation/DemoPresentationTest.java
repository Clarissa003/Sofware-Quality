package com.nhlstenden.presentation;

import com.nhlstenden.slide.BitmapItem;
import com.nhlstenden.slide.Slide;
import com.nhlstenden.slide.TextItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DemoPresentationTest
{

    private DemoPresentation demoPresentation;
    private Presentation presentation;

    @BeforeEach
    public void setUp()
    {
        demoPresentation = new DemoPresentation();
        presentation = new Presentation();
    }

    @Test
    public void testLoadFile()
    {
        demoPresentation.loadFile(presentation, "");

        assertEquals("Demo com.nhlstenden.presentation.Presentation", presentation.getTitle());

        assertEquals(3, presentation.getSize());

        Slide firstSlide = presentation.getSlide(0);
        assertEquals("JabberPoint", firstSlide.getTitle());
        assertEquals(10, firstSlide.getSlideItems().size());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(0));
        assertEquals("The Java com.nhlstenden.presentation.Presentation Tool", firstSlide.getSlideItems().get(0).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(1));
        assertEquals("Copyright (c) 1996-2000: Ian Darwin", firstSlide.getSlideItems().get(1).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(2));
        assertEquals("Copyright (c) 2000-now:", firstSlide.getSlideItems().get(2).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(3));
        assertEquals("Gert Florijn andn Sylvia Stuurman", firstSlide.getSlideItems().get(3).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(4));
        assertEquals("Starting JabberPoint without a filename", firstSlide.getSlideItems().get(4).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(5));
        assertEquals("shows this presentation", firstSlide.getSlideItems().get(5).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(6));
        assertEquals("Navigate:", firstSlide.getSlideItems().get(6).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(7));
        assertEquals("Next slide: PgDn or Enter", firstSlide.getSlideItems().get(7).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(8));
        assertEquals("Previous slide: PgUp or up-arrow", firstSlide.getSlideItems().get(8).getContent());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItems().get(9));
        assertEquals("Quit: q or Q", firstSlide.getSlideItems().get(9).getContent());

        Slide secondSlide = presentation.getSlide(1);
        assertEquals("Demonstration of levels and stijlen", secondSlide.getTitle());
        assertEquals(7, secondSlide.getSlideItems().size());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(0));
        assertEquals("Level 1", secondSlide.getSlideItems().get(0).getContent());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(1));
        assertEquals("Level 2", secondSlide.getSlideItems().get(1).getContent());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(2));
        assertEquals("Again level 1", secondSlide.getSlideItems().get(2).getContent());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(3));
        assertEquals("Level 1 has style number 1", secondSlide.getSlideItems().get(3).getContent());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(4));
        assertEquals("Level 2 has style number  2", secondSlide.getSlideItems().get(4).getContent());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(5));
        assertEquals("This is how level 3 looks like", secondSlide.getSlideItems().get(5).getContent());
        assertInstanceOf(TextItem.class, secondSlide.getSlideItems().get(6));
        assertEquals("And this is level 4", secondSlide.getSlideItems().get(6).getContent());

        Slide thirdSlide = presentation.getSlide(2);
        assertEquals("The third slide", thirdSlide.getTitle());
        assertEquals(5, thirdSlide.getSlideItems().size());
        assertInstanceOf(TextItem.class, thirdSlide.getSlideItems().get(0));
        assertEquals("To open a new presentation,", thirdSlide.getSlideItems().get(0).getContent());
        assertInstanceOf(TextItem.class, thirdSlide.getSlideItems().get(1));
        assertEquals("use File->Open from the menu.", thirdSlide.getSlideItems().get(1).getContent());
        assertInstanceOf(TextItem.class, thirdSlide.getSlideItems().get(2));
        assertEquals(" ", thirdSlide.getSlideItems().get(2).getContent());
        assertInstanceOf(TextItem.class, thirdSlide.getSlideItems().get(3));
        assertEquals("This is the end of the presentation.", thirdSlide.getSlideItems().get(3).getContent());
        assertInstanceOf(BitmapItem.class, thirdSlide.getSlideItems().get(4));
        assertEquals("JabberPoint.jpg", ((BitmapItem) thirdSlide.getSlideItems().get(4)).getName());
    }

    @Test
    public void testSaveFile()
    {
        assertThrows(IllegalStateException.class, () -> demoPresentation.saveFile(presentation, ""));
    }

    @Test
    public void testPresentationTitle()
    {
        presentation.setTitle("Test Title");
        assertEquals("Test Title", presentation.getTitle());
    }

    @Test
    public void testEmptyPresentation()
    {
        Presentation emptyPresentation = new Presentation();
        assertEquals(0, emptyPresentation.getSize());
    }

    @Test
    public void testSlideContents()
    {
        Slide slide = new Slide();
        slide.setTitle("Test Slide");
        slide.append(1, "Item 1");
        slide.append(2, "Item 2");
        assertEquals("Test Slide", slide.getTitle());
        assertEquals(2, slide.getSlideItems().size());

        assertEquals("Item 1", slide.getSlideItems().get(0).getContent());
        assertEquals("Item 2", slide.getSlideItems().get(1).getContent());
    }

    @Test
    public void testAddSlides()
    {
        Slide slide1 = new Slide();
        slide1.setTitle("Slide 1");
        presentation.append(slide1);
        assertEquals(1, presentation.getSize());

        Slide slide2 = new Slide();
        slide2.setTitle("Slide 2");
        presentation.append(slide2);
        assertEquals(2, presentation.getSize());

        assertEquals("Slide 1", presentation.getSlide(0).getTitle());
        assertEquals("Slide 2", presentation.getSlide(1).getTitle());
    }

    @Test
    public void testSlideItems()
    {
        Slide slide = new Slide();
        slide.setTitle("Test Slide");
        slide.append(1, "Item 1");
        slide.append(2, "Item 2");

        assertEquals("Test Slide", slide.getTitle());
        assertEquals(2, slide.getSlideItems().size());
        assertTrue(slide.getSlideItems().get(0) instanceof TextItem);
        assertEquals("Item 1", slide.getSlideItems().get(0).getContent());
        assertTrue(slide.getSlideItems().get(1) instanceof TextItem);
        assertEquals("Item 2", slide.getSlideItems().get(1).getContent());
    }
}