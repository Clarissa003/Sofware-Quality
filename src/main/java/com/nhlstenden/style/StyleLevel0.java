package com.nhlstenden.style;

import com.nhlstenden.style.Style;

import java.awt.*;

public class StyleLevel0 extends Style
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
        return Color.red;
    }

    @Override
    public int getIndent()
    {
        return 0;
    }

    @Override
    public int getFontSize()
    {
        return 48;
    }

    @Override
    public int getLeading()
    {
        return 20;
    }
}
