package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import com.nhlstenden.slide.Slide;
import com.nhlstenden.slide.SlideBuilder;

import java.util.List;

public class SlideDirector
{
    private final SlideBuilder builder;

    public SlideDirector(SlideBuilder builder)
    {
        this.builder = builder;
    }

    //Create slide with the builder
    public Slide createSlide(String title, List<? extends SlideItem> slideItems)
    {
        builder.createTitle(title);
        if (slideItems != null) {
            for (SlideItem item : slideItems) {
                builder.createSlideItem(item);
            }
        }
        return builder.build();
    }
}