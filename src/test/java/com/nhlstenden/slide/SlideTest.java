package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import com.nhlstenden.presentation.SlideViewerComponent;
import com.nhlstenden.style.Style;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.util.Vector;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

public class SlideTest {

    @Test
    public void testAppendAndGetSlideItem() {
        Slide slide = new Slide();
        SlideItem slideItem = Mockito.mock(SlideItem.class);
        slide.append(slideItem);
        assertEquals(slideItem, slide.getSlideItem(0));
    }

    @Test
    public void testGetTitleAndSetTitle() {
        Slide slide = new Slide();
        slide.setTitle("Test Title");
        assertEquals("Test Title", slide.getTitle());
    }

    @Test
    public void testNewBuilder() {
        SlideBuilder simpleBuilder = Slide.newBuilder(false);
        SlideBuilder fancyBuilder = Slide.newBuilder(true);

        assertEquals(SimplePresentationBuilder.class, simpleBuilder.getClass());
        assertEquals(FancyPresentationBuilder.class, fancyBuilder.getClass());
    }

    @Test
    public void testDraw() {
        // Mock objects
        Graphics2D graphics = mock(Graphics2D.class);
        SlideViewerComponent area = mock(SlideViewerComponent.class);

        // Create a slide
        Slide slide = new Slide();
        slide.setTitle("Test Slide");
        slide.append(0, "Title");
        slide.append(1, "Content 1");
        slide.append(1, "Content 2");

        // Stub method calls
        when(graphics.getFontRenderContext()).thenReturn(new FontRenderContext(null, false, false));

        // Call the draw method
        slide.draw(graphics, area, 50); // Adjust contentStartY as needed

        // Verify that the draw method of SlideItem is called for each item
        /*verify(graphics).drawString(eq("Title"), anyInt(), anyInt());
        verify(graphics).drawString(eq("Content 1"), anyInt(), anyInt());
        verify(graphics).drawString(eq("Content 2"), anyInt(), anyInt());*/

        // You might need additional verifications depending on your implementation
    }


}
