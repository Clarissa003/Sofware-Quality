package com.nhlstenden.presentation;

import com.nhlstenden.style.Style;
import com.nhlstenden.style.StyleLevel1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SlideItemTest {

    private SlideItem slideItem;
    private Style style;

    @BeforeEach
    void setUp() {
        slideItem = mock(SlideItem.class);
        style = new StyleLevel1();

        when(slideItem.getStyle(1)).thenReturn(style);
        when(slideItem.getLevel()).thenReturn(1);
    }

    @Test
    public void testGetLevel() {
        assertEquals(1, slideItem.getLevel());
    }

    @Test
    public void testGetStyle() {
        Style retrievedStyle = slideItem.getStyle(1);
        assertEquals(style, retrievedStyle);
    }
}

