package com.nhlstenden.style;

import java.awt.*;

public class StyleLevel4 extends Style
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
        return 90;
    }

    @Override
    public int getFontSize()
    {
        return 24;
    }

    @Override
    public int getLeading()
    {
        return 10;
    }
}
