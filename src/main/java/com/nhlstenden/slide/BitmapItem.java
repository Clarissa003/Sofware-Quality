package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import com.nhlstenden.style.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;


/**
 * <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items have the responsibility to draw themselves.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class BitmapItem extends SlideItem
{
    BufferedImage bufferedImage;
    private final String imageName;

    protected static final String FILE = "File ";
    protected static final String NOTFOUND = " not found";

    // level is equal to item-level; name is the name of the file with the Image
    public BitmapItem(int level, String name)
    {
        super(Style.getStyleForLevel(level), level);
        imageName = name;
        try
        {
            bufferedImage = ImageIO.read(new File (imageName));
        }
        catch(IOException e)
        {
            System.err.println(FILE + imageName + NOTFOUND);
        }
    }

    // An empty bitmap-item
    public BitmapItem()
    {
        this(0, null);
    }

    // give the filename of the image
    public String getName()
    {
        return imageName;
    }

    @Override
    public String getContent()
    {
        return imageName;
    }

// draw the image
	public void draw(int xPos, int yPos, float scale, Graphics graphics, Style myStyle, ImageObserver observer) {
		int width = xPos + (int) (getStyle(level).getIndent() * scale);
		int height = yPos + (int) (getStyle(level).getLeading() * scale);
		graphics.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
                (int) (bufferedImage.getHeight(observer)*scale), observer);
	}
    // give the  bounding box of the image
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style myStyle)
    {
        return new Rectangle((int) (getStyle (level).getIndent() * scale), 0, (int) (bufferedImage.getWidth(observer) * scale), ((int) (getStyle(level).getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
    }

    public String toString()
    {
        return "com.nhlstenden.slide.BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}
