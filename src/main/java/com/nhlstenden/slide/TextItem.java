package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import com.nhlstenden.style.Style;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * <p>A tekst item.</p>
 * <p>A com.nhlstenden.slide.TextItem has drawingfunctionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem
{
    private final String text;

    private static final String EMPTYTEXT = "No Text Given";

    // a textitem of level with the text string
    public TextItem(int level, String string)
    {
        super(Style.getStyleForLevel(level), level);
        text = string;
    }

    // an empty textitem
    public TextItem()
    {
        this(0, EMPTYTEXT);
    }

    //get content from slideItem
    @Override
    public String getContent()
    {
        return text;
    }

    // get the text
    public String getText()
    {
        return text == null ? "" : text;
    }

    // get de AttributedString for the item
    public AttributedString getAttributedString(Style style, float scale)
    {
        Font font = new Font(this.getStyle(level).getFontName(), Font.PLAIN, style.getFontSize());
        AttributedString attrStr = new AttributedString(getText());
        attrStr.addAttribute(TextAttribute.FONT, font, 0, text.length());
        return attrStr;
    }

    // get the bounding box of the item
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer,
                                    float scale, Style myStyle)
    {
        List<TextLayout> layouts = getLayouts(graphics, myStyle, scale);
        int xsize = 0, ysize = (int) (getStyle(level).getLeading() * scale);
        Iterator<TextLayout> iterator = layouts.iterator();
        while (iterator.hasNext()) {
            TextLayout layout = iterator.next();
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > xsize) {
                xsize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0) {
                ysize += bounds.getHeight();
            }
            ysize += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (getStyle(level).getIndent() * scale), 0, xsize, ysize);
    }

    // draw the item
    public void draw(int xPos, int yPos, float scale, Graphics graphics,
                     Style myStyle, ImageObserver o)
    {
        if (text == null || text.length() == 0) {
            return;
        }
        List<TextLayout> layouts = getLayouts(graphics, myStyle, scale);
        Point pen = new Point(xPos + (int) (getStyle(level).getIndent() * scale),
                yPos + (int) (getStyle(level).getLeading() * scale));
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(getStyle(level).getColor());
        Iterator<TextLayout> it = layouts.iterator();
        while (it.hasNext()) {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    private List<TextLayout> getLayouts(Graphics graphics, Style style, float scale)
    {
        List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attrStr = getAttributedString(style, scale);
        Graphics2D g2d = (Graphics2D) graphics;
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.WIDTH - getStyle(level).getIndent()) * scale;
        while (measurer.getPosition() < getText().length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }
        return layouts;
    }

    public String toString()
    {
        return "com.nhlstenden.slide.TextItem[" + getLevel() + "," + getText() + "]";
    }
}
