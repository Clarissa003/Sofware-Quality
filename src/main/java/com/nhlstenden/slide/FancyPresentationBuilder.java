package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;

public class FancyPresentationBuilder implements SlideBuilder
{
    private final Slide slide;

    public FancyPresentationBuilder()
    {
        slide = new Slide();
    }

    @Override
    public SlideBuilder createTitle(String title)
    {
        slide.setTitle("Fancy:" + title);
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
        slide.append(new TextItem(1, text));
        return this;
    }

    @Override
    public Slide build()
    {
        return slide;
    }
}
