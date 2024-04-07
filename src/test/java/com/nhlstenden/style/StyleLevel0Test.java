package com.nhlstenden.style;

import com.nhlstenden.style.StyleLevel0;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class StyleLevel0Test {

    @Test
    public void testGetFontName_ExpectEquals() {
        StyleLevel0 style = new StyleLevel0();
        assertEquals("Helvetica", style.getFontName());
    }

    @Test
    public void testGetFontName_ExpectNotEqual() {
        StyleLevel0 style = new StyleLevel0();
        assertNotEquals("Arial", style.getFontName());
    }

    @Test
    public void testGetColor_ExpectEquals() {
        StyleLevel0 style = new StyleLevel0();
        assertEquals(Color.red, style.getColor());
    }

    @Test
    public void testGetColor_ExpectNotEqual() {
        StyleLevel0 style = new StyleLevel0();
        assertNotEquals(Color.blue, style.getColor());
    }

    @Test
    public void testGetIndent_ExpectEquals() {
        StyleLevel0 style = new StyleLevel0();
        assertEquals(0, style.getIndent());
    }

    @Test
    public void testGetIndent_ExpectNotEqual() {
        StyleLevel0 style = new StyleLevel0();
        assertNotEquals(10, style.getIndent());
    }

    @Test
    public void testGetFontSize_ExpectEqual() {
        StyleLevel0 style = new StyleLevel0();
        assertEquals(48, style.getFontSize());
    }

    @Test
    public void testGetFontSize_ExpectNotEqual() {
        StyleLevel0 style = new StyleLevel0();
        assertNotEquals(20, style.getFontSize());
    }

    @Test
    public void testGetLeading_ExpectEquals() {
        StyleLevel0 style = new StyleLevel0();
        assertEquals(20, style.getLeading());
    }

    @Test
    public void testGetLeading_ExpectNotEqual() {
        StyleLevel0 style = new StyleLevel0();
        assertNotEquals(10, style.getLeading());
    }
}
