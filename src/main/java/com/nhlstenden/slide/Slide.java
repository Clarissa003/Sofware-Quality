package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import com.nhlstenden.presentation.SlideViewerComponent;
import com.nhlstenden.style.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>A slide. This class has a drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    protected String title; // title is saved separately
    protected Vector<SlideItem> items; // slide items are saved in a Vector

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
	public String getTitle() {
		return title;
	}

	// Change the title of the slide
	public void setTitle(String newTitle) {
		title = newTitle;
	}

    // Create com.nhlstenden.slide.TextItem of String, and add the com.nhlstenden.slide.TextItem
    public void append(int level, String message)
    {
        append(new TextItem(level, message));
    }

	// Get the  com.nhlstenden.presentation.SlideItem
	public SlideItem getSlideItem(int number) {
		return (SlideItem)items.elementAt(number);
	}

	// Get all SlideItems in a Vector
	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	// Get the size of the com.nhlstenden.slide.Slide
	public int getSize() {
		return items.size();
	}

	// draw the slide
	public void draw(Graphics graphics, SlideViewerComponent area, Rectangle view) {
		float scale = getScale(area);
	    int yPos = area.getY();
		System.out.println("Drawing slide: " + getTitle());
		// Title is handled separately
		SlideItem titleItem = new TextItem(0, getTitle());
		Style titleStyle = titleItem.getStyle(titleItem.getLevel());
		if (titleStyle != null) {
			titleItem.draw(area.getX(), yPos, scale, graphics, titleStyle, (ImageObserver) view);
			yPos += titleItem.getBoundingBox(graphics, (ImageObserver) view, scale, titleStyle).height;
		} else {
			System.err.println("Error: Title style is null"); // Error handling
		}

		for (int number = 0; number < getSize(); number++) {
			SlideItem slideItem = getSlideItem(number);
			Style style = slideItem.getStyle(slideItem.getLevel()); //Get style level
			if (style != null) {
				//Print the content with the desired level
				System.out.println("Drawing slide item " + number + ": " + slideItem.getContent());
				slideItem.draw(area.getX(), yPos, scale, graphics, style, (ImageObserver) view);
				yPos += slideItem.getBoundingBox(graphics, (ImageObserver) view, scale, style).height;
			} else {
				System.err.println("Error: com.nhlstenden.style.Style is null for slide item " + number); // Error handling
			}
		}
	  }

    // Give the scale for drawing
    private float getScale(SlideViewerComponent area)
    {
        return Math.min (((float) area.getWidth()) / ((float) WIDTH), ((float) area.getHeight()) / ((float) HEIGHT));
    }

	//Gives option to choose between different slide builders
    public static SlideBuilder newBuilder(boolean isFancy)
    {
        if(isFancy)
        {
            return new FancyPresentationBuilder();
        }
        else
        {
            return new SimplePresentationBuilder();
        }
    }
}
