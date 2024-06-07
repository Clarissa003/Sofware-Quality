package com.nhlstenden.slide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BitmapItemTest
{

    @Test
    void constructor_withInvalidImageName_shouldNotLoadImage()
    {
        String invalidImageName = "invalid_image.png";
        BitmapItem bitmapItem = new BitmapItem(0, invalidImageName);

        assertNull(bitmapItem.bufferedImage);
    }

    @Test
    void toString_shouldReturnExpectedString()
    {
        BitmapItem bitmapItem = new BitmapItem(1, "image.png");

        String result = bitmapItem.toString();

        assertEquals("com.nhlstenden.slide.BitmapItem[1,image.png]", result);
    }
}
