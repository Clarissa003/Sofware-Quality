package com.nhlstenden.presentation;

import com.nhlstenden.style.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * <p>The abstract class for an item on a slide<p>
 * <p>All SlideItems have drawingfunctionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class SlideItem
{
    protected Style style;
    protected int level;

    public SlideItem(Style style, int level)
    {
        this.style = style;
        this.level = level;
    }

    public int getLevel()
    {
        return level;
    }

    public Style getStyle(int level)
    {
        return Style.getStyleForLevel(level);
    }

    public abstract Rectangle getBoundingBox(Graphics graphics,
                                             ImageObserver observer, float scale, Style style);

    public abstract void draw(int xPos, int yPos, float scale,
                              Graphics graphics, Style style, ImageObserver observer);

    public abstract String getContent();
}
