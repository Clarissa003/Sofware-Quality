package com.nhlstenden.style;

import com.nhlstenden.style.Style;

import java.awt.*;

public class StyleLevel1 extends Style
{
    //Set values for style
    @Override
    public String getFontName()
    {
        return "Helvetica";
    }

    @Override
    public Color getColor()
    {
        return Color.blue;
    }

    @Override
    public int getIndent()
    {
        return 20;
    }

    @Override
    public int getFontSize()
    {
        return 40;
    }

    @Override
    public int getLeading()
    {
        return 10;
    }
}
