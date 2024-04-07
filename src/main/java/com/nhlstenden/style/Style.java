package com.nhlstenden.style;

import java.awt.Color;

/**
 * <p>com.nhlstenden.style.Style is for Indent, Color, Font and Leading.</p>
 * <p>Direct relation between style-number and item-level:
 * in com.nhlstenden.slide.Slide style if fetched for an item
 * with style-number as item-level.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class Style
{
    // Create concrete style instances based on the level
    public static Style getStyleForLevel(int level)
    {
        switch (level) {
            case 0:
                return new StyleLevel0();
            case 1:
                return new StyleLevel1();
            case 2:
                return new StyleLevel2();
            case 3:
                return new StyleLevel3();
            case 4:
                return new StyleLevel4();
            default:
                throw new IllegalArgumentException("Invalid style level: " + level);
        }
    }

    public abstract String getFontName();

    public abstract Color getColor();

    public abstract int getIndent();

    public abstract int getFontSize();

    public abstract int getLeading();
}