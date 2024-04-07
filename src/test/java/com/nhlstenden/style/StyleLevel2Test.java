package com.nhlstenden.style;

import com.nhlstenden.style.StyleLevel2;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class StyleLevel2Test {

    @Test
    public void testGetFontName_ExpectEquals() {
        StyleLevel2 style = new StyleLevel2();
        assertEquals("Helvetica", style.getFontName());
    }

    @Test
    public void testGetFontName_ExpectNotEqual() {
        StyleLevel2 style = new StyleLevel2();
        assertNotEquals("Arial", style.getFontName());
    }

    @Test
    public void testGetColor_ExpectEquals() {
        StyleLevel2 style = new StyleLevel2();
        assertEquals(Color.black, style.getColor());
    }

    @Test
    public void testGetColor_ExpectNotEqual() {
        StyleLevel2 style = new StyleLevel2();
        assertNotEquals(Color.red, style.getColor());
    }

    @Test
    public void testGetIndent_ExpectEquals() {
        StyleLevel2 style = new StyleLevel2();
        assertEquals(50, style.getIndent());
    }

    @Test
    public void testGetIndent_ExpectNotEqual() {
        StyleLevel2 style = new StyleLevel2();
        assertNotEquals(20, style.getIndent());
    }

    @Test
    public void testGetFontSize_ExpectEquals() {
        StyleLevel2 style = new StyleLevel2();
        assertEquals(36, style.getFontSize());
    }

    @Test
    public void testGetFontSize_ExpectNotEqual() {
        StyleLevel2 style = new StyleLevel2();
        assertNotEquals(20, style.getFontSize());
    }

    @Test
    public void testGetLeading_ExpectEquals() {
        StyleLevel2 style = new StyleLevel2();
        assertEquals(10, style.getLeading());
    }

    @Test
    public void testGetLeading_ExpectNotEqual() {
        StyleLevel2 style = new StyleLevel2();
        assertNotEquals(5, style.getLeading());
    }
}
