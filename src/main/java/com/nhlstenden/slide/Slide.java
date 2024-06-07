package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import com.nhlstenden.presentation.SlideViewerComponent;
import com.nhlstenden.style.Style;

import java.awt.Graphics;
import java.util.Vector;

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    protected String title;
    protected Vector<SlideItem> items;

    public Slide()
    {
        items = new Vector<SlideItem>();
    }

    // Add a slide item
    public void append(SlideItem anItem)
    {
        items.addElement(anItem);
    }

    // Get the title of the slide
    public String getTitle()
    {
        return title;
    }

    // Change the title of the slide
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public void append(int level, String message)
    {
        append(new TextItem(level, message));
    }

    public SlideItem getSlideItem(int number)
    {
        return items.elementAt(number);
    }

    public Vector<SlideItem> getSlideItems()
    {
        return items;
    }

    public int getSize()
    {
        return items.size();
    }

    public void draw(Graphics graphics, SlideViewerComponent area, int contentStartY)
    {
        float scale = getScale(area);
        int yPos = contentStartY;
        System.out.println("Drawing slide: " + getTitle());
        SlideItem titleItem = new TextItem(0, getTitle());
        Style titleStyle = titleItem.getStyle(titleItem.getLevel());
        if (titleStyle != null)
        {
            titleItem.draw(area.getX(), yPos, scale, graphics, titleStyle, area);
            yPos += titleItem.getBoundingBox(graphics, area, scale, titleStyle).height;
        }
        else
        {
            System.err.println("Error: Title style is null");
        }

        for (int number = 0; number < getSize(); number++)
        {
            SlideItem slideItem = getSlideItem(number);
            Style style = slideItem.getStyle(slideItem.getLevel());
            if (style != null)
            {
                System.out.println("Drawing slide item " + number + ": " + slideItem.getContent());
                slideItem.draw(area.getX(), yPos, scale, graphics, style, area);
                yPos += slideItem.getBoundingBox(graphics, area, scale, style).height;
            }
            else
            {
                System.err.println("Error: com.nhlstenden.style.Style is null for slide item " + number);
            }
        }
    }

    // Give the scale for drawing
    private float getScale(SlideViewerComponent area) {
        return Math.min(((float) area.getWidth()) / ((float) WIDTH), ((float) area.getHeight()) / ((float) HEIGHT));
    }

    //Gives option to choose between different slide builders
    public static SlideBuilder newBuilder(boolean isFancy) {
        if (isFancy) {
            return new FancySlideBuilder();
        } else {
            return new SimpleSlideBuilder();
        }
    }
}
