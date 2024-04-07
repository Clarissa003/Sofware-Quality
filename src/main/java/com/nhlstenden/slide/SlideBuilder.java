package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;

public interface SlideBuilder
{
    SlideBuilder createTitle(String title);
    SlideBuilder createSlideItem(SlideItem item);
    SlideBuilder createText(String text);
    Slide build();
}
