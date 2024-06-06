package com.nhlstenden.style;

import java.awt.*;

public class StyleLevel2 extends Style
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
        return Color.black;
    }

    @Override
    public int getIndent()
    {
        return 50;
    }

    @Override
    public int getFontSize()
    {
        return 36;
    }

    @Override
    public int getLeading()
    {
        return 10;
    }
}
