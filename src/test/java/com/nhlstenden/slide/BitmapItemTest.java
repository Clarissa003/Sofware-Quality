package com.nhlstenden.slide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.nhlstenden.style.Style;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

class BitmapItemTest {

    @Test
    void constructor_withInvalidImageName_shouldNotLoadImage() {
        // Arrange
        String invalidImageName = "invalid_image.png";
        BitmapItem bitmapItem = new BitmapItem(0, invalidImageName);

        // Act & Assert
        assertNull(bitmapItem.bufferedImage);
    }



    @Test
    void toString_shouldReturnExpectedString() {
        // Arrange
        BitmapItem bitmapItem = new BitmapItem(1, "image.png");

        // Act
        String result = bitmapItem.toString();

        // Assert
        assertEquals("com.nhlstenden.slide.BitmapItem[1,image.png]", result);
    }
}
