package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.slide.Slide;
import com.nhlstenden.slide.SlideDirector;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class MenuControllerTest {

    private MenuController menuController;
    private JOptionPane optionPaneMock;

    @Before
    public void setUp() {
        Frame frameMock = Mockito.mock(Frame.class);
        Accessor accessorMock = Mockito.mock(Accessor.class);
        optionPaneMock = Mockito.mock(JOptionPane.class); // Assign to the class field

        // Mocking the presentation instance
        Presentation presentationMock = Mockito.mock(Presentation.class);

        menuController = new MenuController(frameMock, presentationMock, accessorMock);
        menuController.setOptionPane(optionPaneMock);
    }




    @Test
    public void testIsSlideCreationRequested_ExpectFalse() {
        Assertions.assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testIsSlideCreationRequested_ExpectTrue() {
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
    }

    @Test
    public void testClearSlideCreationRequest() {
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
        menuController.clearSlideCreationRequest();
        Assertions.assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testSetNewSlideRequested_ExpectFalse() {
        Assertions.assertFalse(menuController.isSlideCreationRequested());
    }

    @Test
    public void testSetNewSlideRequested_ExpectTrue() {
        Assertions.assertFalse(menuController.isSlideCreationRequested());
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
    }

    /*@Test
    public void testShowCreateSlideDialog() {
        // Mock user input for slide creation dialog
        Mockito.when(menuController.shouldCreateFancySlide()).thenReturn(true);

        // Mock user input for slide title and content
        Mockito.when(menuController.optionPane.showInputDialog(Mockito.any(Component.class), Mockito.eq("Enter slide title:")))
                .thenReturn("Test Slide");
        Mockito.when(menuController.optionPane.showInputDialog(Mockito.any(Component.class), Mockito.eq("Enter slide content (empty line to finish):")))
                .thenReturn("Test Content", "");

        // Mock slide creation
        SlideDirector slideDirectorMock = Mockito.mock(SlideDirector.class);
        Slide slideMock = Mockito.mock(Slide.class);
        Mockito.when(slideDirectorMock.createSlide(Mockito.eq("Test Slide"), Mockito.anyList())).thenReturn(slideMock);

        // Call the method
        menuController.setNewSlideRequested(true);
        menuController.showCreateSlideDialog();

        // Verify that new slide is added to presentation
        Mockito.verify(menuController.presentation, Mockito.times(1)).append(slideMock);
    }*/


    /*@Test
    public void testShouldCreateFancySlide_YesOption() {
        // Mock user input for creating fancy slide
        JOptionPane optionPaneMock = Mockito.mock(JOptionPane.class);
        Mockito.when(optionPaneMock.showConfirmDialog(Mockito.any(Component.class), Mockito.eq("Create Fancy Slide?"),
                        Mockito.eq("Choose Slide Type"), Mockito.eq(JOptionPane.YES_NO_OPTION), Mockito.eq(JOptionPane.QUESTION_MESSAGE)))
                .thenReturn(JOptionPane.YES_OPTION);
        menuController.setOptionPane(optionPaneMock);

        Assertions.assertTrue(menuController.shouldCreateFancySlide());
    }

    @Test
    public void testShouldCreateFancySlide_NoOption() {
        // Mock user input for not creating fancy slide
        JOptionPane optionPaneMock = Mockito.mock(JOptionPane.class);
        Mockito.when(optionPaneMock.showConfirmDialog(
                        Mockito.any(Component.class),
                        Mockito.eq("Create Fancy Slide?"),
                        Mockito.eq("Choose Slide Type"),
                        Mockito.eq(JOptionPane.YES_NO_OPTION),
                        Mockito.eq(JOptionPane.QUESTION_MESSAGE)))
                .thenReturn(JOptionPane.NO_OPTION);
        menuController.setOptionPane(optionPaneMock);

        Assertions.assertFalse(menuController.shouldCreateFancySlide());
    }*/

}
