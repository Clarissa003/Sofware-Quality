package com.nhlstenden.style;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class StyleLevel3Test {

    @Test
    public void testGetFontName_ExpectEquals() {
        StyleLevel3 style = new StyleLevel3();
        assertEquals("Helvetica", style.getFontName());
    }

    @Test
    public void testGetFontName_ExpectNotEqual() {
        StyleLevel3 style = new StyleLevel3();
        assertNotEquals("Arial", style.getFontName());
    }

    @Test
    public void testGetColor_ExpectEquals() {
        StyleLevel3 style = new StyleLevel3();
        assertEquals(Color.black, style.getColor());
    }

    @Test
    public void testGetColor_ExpectNotEqual() {
        StyleLevel3 style = new StyleLevel3();
        assertNotEquals(Color.red, style.getColor());
    }

    @Test
    public void testGetIndent_ExpectEquals() {
        StyleLevel3 style = new StyleLevel3();
        assertEquals(70, style.getIndent());
    }

    @Test
    public void testGetIndent_ExpectNotEqual() {
        StyleLevel3 style = new StyleLevel3();
        assertNotEquals(20, style.getIndent());
    }

    @Test
    public void testGetFontSize_ExpectEquals() {
        StyleLevel3 style = new StyleLevel3();
        assertEquals(30, style.getFontSize());
    }

    @Test
    public void testGetFontSize_ExpectNotEqual() {
        StyleLevel3 style = new StyleLevel3();
        assertNotEquals(20, style.getFontSize());
    }

    @Test
    public void testGetLeading_ExpectEquals() {
        StyleLevel3 style = new StyleLevel3();
        assertEquals(10, style.getLeading());
    }

    @Test
    public void testGetLeading_ExpectNotEqual() {
        StyleLevel3 style = new StyleLevel3();
        assertNotEquals(5, style.getLeading());
    }
}
