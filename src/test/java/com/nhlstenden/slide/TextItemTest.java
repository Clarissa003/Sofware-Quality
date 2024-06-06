package com.nhlstenden.slide;

import com.nhlstenden.style.Style;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TextItemTest {

    private TextItem textItem;
    private TextItem emptyTextItem;
    private Style mockStyle;
    private Graphics2D realGraphics;
    private ImageObserver mockObserver;

    @Before
    public void setUp() {
        textItem = new TextItem(1, "Test text");
        emptyTextItem = new TextItem();
        mockStyle = mock(Style.class);
        mockObserver = mock(ImageObserver.class);

        when(mockStyle.getFontName()).thenReturn("Serif");
        when(mockStyle.getFontSize()).thenReturn(12);
        when(mockStyle.getLeading()).thenReturn(10);
        when(mockStyle.getIndent()).thenReturn(20);
        when(mockStyle.getColor()).thenReturn(Color.BLACK);

        // Set up a real Graphics2D object
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        realGraphics = image.createGraphics();
        realGraphics.setTransform(new AffineTransform());
    }

    @Test
    public void testConstructorWithText() {
        TextItem item = new TextItem(2, "Sample text");
        assertEquals(2, item.getLevel());
        assertEquals("Sample text", item.getText());
    }

    @Test
    public void testConstructorWithoutText() {
        TextItem item = new TextItem();
        assertEquals(0, item.getLevel());
        assertEquals("No Text Given", item.getText());
    }

    @Test
    public void testGetText() {
        assertEquals("Test text", textItem.getText());
    }

    @Test
    public void testGetText_EmptyText() {
        assertEquals("No Text Given", emptyTextItem.getText());
    }

    @Test
    public void testGetAttributedString() {
        AttributedString attributedString = textItem.getAttributedString(mockStyle, 1.0f);
        assertNotNull(attributedString);
        AttributedCharacterIterator iterator = attributedString.getIterator();
        StringBuilder sb = new StringBuilder();
        for (char ch = iterator.first(); ch != AttributedCharacterIterator.DONE; ch = iterator.next()) {
            sb.append(ch);
        }
        assertEquals("Test text", sb.toString());
    }

    @Test
    public void testGetAttributedString_EmptyText() {
        AttributedString attributedString = emptyTextItem.getAttributedString(mockStyle, 1.0f);
        assertNotNull(attributedString);
        AttributedCharacterIterator iterator = attributedString.getIterator();
        StringBuilder sb = new StringBuilder();
        for (char ch = iterator.first(); ch != AttributedCharacterIterator.DONE; ch = iterator.next()) {
            sb.append(ch);
        }
        assertEquals("No Text Given", sb.toString());
    }

    @Test
    public void testGetBoundingBox() {
        Rectangle boundingBox = textItem.getBoundingBox(realGraphics, mockObserver, 1.0f, mockStyle);
        assertNotNull(boundingBox);
        assertTrue(boundingBox.width > 0);
        assertTrue(boundingBox.height > 0);
    }

    @Test
    public void testDraw() {
        // Call draw to ensure no exceptions are thrown
        textItem.draw(0, 0, 1.0f, realGraphics, mockStyle, mockObserver);

        // As we can't verify realGraphics with mock, we'll check that the draw method executes successfully
        // The verification part for the actual drawing would be visual/manual
    }

    @Test
    public void testToString() {
        String result = textItem.toString();
        assertEquals("com.nhlstenden.slide.TextItem[1,Test text]", result);
    }

    @Test
    public void testToString_EmptyText() {
        String result = emptyTextItem.toString();
        assertEquals("com.nhlstenden.slide.TextItem[0,No Text Given]", result);
    }

}

