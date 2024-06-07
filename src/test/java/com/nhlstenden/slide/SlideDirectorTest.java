package com.nhlstenden.slide;

import com.nhlstenden.presentation.SlideItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlideDirectorTest
{

    private SlideDirector director;

    @BeforeEach
    public void setup()
    {
        SlideBuilder builder = new SimpleSlideBuilder();
        director = new SlideDirector(builder);
    }

    @Test
    public void testSlideDirector()
    {
        List<SlideItem> slideItems = new ArrayList<>();
        slideItems.add(new TextItem(1, "Text 1"));
        slideItems.add(new TextItem(2, "Text 2"));

        Slide slide = director.createSlide("Test com.nhlstenden.slide.Slide", slideItems);

        assertEquals("Test com.nhlstenden.slide.Slide", slide.getTitle());
        assertEquals(2, slide.getSize());

        assertEquals("Text 1", slide.getSlideItem(0).getContent());
        assertEquals("Text 2", slide.getSlideItem(1).getContent());
    }

    @Test
    public void testSlideDirectorWithEmptyList()
    {
        List<SlideItem> emptySlideItems = new ArrayList<>();

        Slide slide = director.createSlide("Empty com.nhlstenden.slide.Slide", emptySlideItems);

        assertEquals("Empty com.nhlstenden.slide.Slide", slide.getTitle());
        assertEquals(0, slide.getSize());
    }

    @Test
    public void testSlideDirectorWithNullList()
    {
        Slide slide = director.createSlide("Null com.nhlstenden.slide.Slide", null);

        assertEquals("Null com.nhlstenden.slide.Slide", slide.getTitle());
        assertEquals(0, slide.getSize());
    }
}
