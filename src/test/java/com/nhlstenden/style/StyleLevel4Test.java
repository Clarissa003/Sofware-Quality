package com.nhlstenden.style;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class StyleLevel4Test
{

    @Test
    public void testGetFontName_ExpectEquals()
    {
        StyleLevel4 style = new StyleLevel4();
        assertEquals("Helvetica", style.getFontName());
    }

    @Test
    public void testGetFontName_ExpectNotEqual()
    {
        StyleLevel4 style = new StyleLevel4();
        assertNotEquals("Arial", style.getFontName());
    }

    @Test
    public void testGetColor_ExpectEquals()
    {
        StyleLevel4 style = new StyleLevel4();
        assertEquals(Color.black, style.getColor());
    }

    @Test
    public void testGetColor_ExpectNotEqual()
    {
        StyleLevel4 style = new StyleLevel4();
        assertNotEquals(Color.blue, style.getColor());
    }

    @Test
    public void testGetIndent_ExpectEquals()
    {
        StyleLevel4 style = new StyleLevel4();
        assertEquals(90, style.getIndent());
    }

    @Test
    public void testGetIndent_ExpectNotEqual()
    {
        StyleLevel4 style = new StyleLevel4();
        assertNotEquals(70, style.getIndent());
    }

    @Test
    public void testGetFontSize_ExpectEquals()
    {
        StyleLevel4 style = new StyleLevel4();
        assertEquals(24, style.getFontSize());
    }

    @Test
    public void testGetFontSize_ExpectNotEqual()
    {
        StyleLevel4 style = new StyleLevel4();
        assertNotEquals(30, style.getFontSize());
    }

    @Test
    public void testGetLeading_ExpectEquals()
    {
        StyleLevel4 style = new StyleLevel4();
        assertEquals(10, style.getLeading());
    }

    @Test
    public void testGetLeading_ExpectNotEqual()
    {
        StyleLevel4 style = new StyleLevel4();
        assertNotEquals(5, style.getLeading());
    }
}
