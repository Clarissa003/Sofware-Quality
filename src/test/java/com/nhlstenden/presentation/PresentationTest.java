package com.nhlstenden.presentation;

import com.nhlstenden.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class PresentationTest
{

    private Presentation presentation;

    @BeforeEach
    public void setUp()
    {
        SlideViewerComponent mockSlideViewerComponent = mock(SlideViewerComponent.class);
        presentation = new Presentation(mockSlideViewerComponent);
    }

    @Test
    public void testGetSize()
    {
        assertEquals(0, presentation.getSize());
        presentation.append(new Slide());
        assertEquals(1, presentation.getSize());
    }

    @Test
    public void testSetTitle()
    {
        presentation.setTitle("Test Title");
        assertEquals("Test Title", presentation.getTitle());
    }

    @Test
    public void testGetSlideNumber()
    {
        presentation.setSlideNumber(2);
        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    public void testSetSlideNumber()
    {
        presentation.setSlideNumber(2);
        assertEquals(2, presentation.getSlideNumber());
    }

    @Test
    public void testPrevSlide()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(1);
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testNextSlide()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);
        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());
        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testClear()
    {
        presentation.append(new Slide());
        presentation.setSlideNumber(1);
        presentation.clear();
        assertEquals(0, presentation.getSize());
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testAppendAndGetSlide()
    {
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        assertEquals(slide1, presentation.getSlide(0));
        assertEquals(slide2, presentation.getSlide(1));
        assertNull(presentation.getSlide(2));
    }

    @Test
    public void testGetCurrentSlide()
    {
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);
        assertEquals(slide2, presentation.getCurrentSlide());
    }

    @Test
    public void testObservers()
    {
        PresentationObserverMock observer1 = new PresentationObserverMock();
        PresentationObserverMock observer2 = new PresentationObserverMock();

        presentation.addObserver(observer1);
        presentation.addObserver(observer2);

        presentation.notifyObservers();

        assertEquals(1, observer1.getUpdateCallCount());
        assertEquals(1, observer2.getUpdateCallCount());
    }

    static class PresentationObserverMock implements PresentationObserver
    {
        private int updateCallCount = 0;

        @Override
        public void update()
        {
            updateCallCount++;
        }

        public int getUpdateCallCount()
        {
            return updateCallCount;
        }
    }

    @Test
    public void testNotifyObservers()
    {
        PresentationObserver observer = mock(PresentationObserver.class);
        presentation.addObserver(observer);
        presentation.notifyObservers();
        verify(observer, times(1)).update();
    }

}
