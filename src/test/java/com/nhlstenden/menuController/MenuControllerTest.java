package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

public class MenuControllerTest
{

    private MenuController menuController;
    private JOptionPane optionPaneMock;

    @Before
    public void setUp()
    {
        Frame frameMock = Mockito.mock(Frame.class);
        Accessor accessorMock = Mockito.mock(Accessor.class);
        optionPaneMock = Mockito.mock(JOptionPane.class);

        Presentation presentationMock = Mockito.mock(Presentation.class);

        menuController = new MenuController(frameMock, presentationMock, accessorMock);
        menuController.setOptionPane(optionPaneMock);
    }




    @Test
    public void testIsSlideCreationRequested_ExpectFalse()
    {
        Assertions.assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testIsSlideCreationRequested_ExpectTrue()
    {
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
    }

    @Test
    public void testClearSlideCreationRequest()
    {
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
        menuController.clearSlideCreationRequest();
        Assertions.assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testSetNewSlideRequested_ExpectFalse()
    {
        Assertions.assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testSetNewSlideRequested_ExpectTrue()
    {
        Assertions.assertFalse(menuController.isSlideCreationRequested());
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
    }
}
