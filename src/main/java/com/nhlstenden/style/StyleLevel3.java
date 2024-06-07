package com.nhlstenden.style;

import java.awt.*;

public class StyleLevel3 extends Style
{
    @Override
    public String getFontName()
    {
        return "Helvetica";
    }

    @Override
    public Color getColor()
    {
        return Color.black;
    }

    @Override
    public int getIndent()
    {
        return 70;
    }

    @Override
    public int getFontSize()
    {
        return 30;
    }

    @Override
    public int getLeading()
    {
        return 10;
    }
}
