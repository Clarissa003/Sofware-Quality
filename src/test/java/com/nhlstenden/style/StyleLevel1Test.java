package com.nhlstenden.style;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class StyleLevel1Test
{

    @Test
    public void testGetFontName_ExpectEquals() {
        StyleLevel1 style = new StyleLevel1();
        assertEquals("Helvetica", style.getFontName());
    }

    @Test
    public void testGetFontName_ExpectNotEqual() {
        StyleLevel1 style = new StyleLevel1();
        assertNotEquals("Arial", style.getFontName());
    }

    @Test
    public void testGetColor_ExpectEquals() {
        StyleLevel1 style = new StyleLevel1();
        assertEquals(Color.blue, style.getColor());
    }

    @Test
    public void testGetColor_ExpectNotEqual() {
        StyleLevel1 style = new StyleLevel1();
        assertNotEquals(Color.red, style.getColor());
    }

    @Test
    public void testGetIndent_ExpectEquals() {
        StyleLevel1 style = new StyleLevel1();
        assertEquals(20, style.getIndent());
    }

    @Test
    public void testGetIndent_ExpectNotEqual() {
        StyleLevel1 style = new StyleLevel1();
        assertNotEquals(10, style.getIndent());
    }

    @Test
    public void testGetFontSize_ExpectEquals() {
        StyleLevel1 style = new StyleLevel1();
        assertEquals(40, style.getFontSize());
    }

    @Test
    public void testGetFontSize_ExpectNotEqual() {
        StyleLevel1 style = new StyleLevel1();
        assertNotEquals(20, style.getFontSize());
    }

    @Test
    public void testGetLeading_ExpectEquals() {
        StyleLevel1 style = new StyleLevel1();
        assertEquals(10, style.getLeading());
    }

    @Test
    public void testGetLeading_ExpectNotEqual() {
        StyleLevel1 style = new StyleLevel1();
        assertNotEquals(5, style.getLeading());
    }
}