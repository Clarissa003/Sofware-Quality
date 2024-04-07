package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;

public class SimplePresentationBuilder implements SlideBuilder
{
    private final Slide slide;

    public SimplePresentationBuilder()
    {
        slide = new Slide();
    }

    @Override
    public SlideBuilder createTitle(String title)
    {
        slide.setTitle(title);
        return this;
    }

    @Override
    public SlideBuilder createSlideItem(SlideItem item)
    {
        slide.append(item);
        return this;
    }

    @Override
    public SlideBuilder createText(String text)
    {
        slide.append(0, text);
        return this;
    }

    @Override
    public Slide build()
    {
        return slide;
    }
}
