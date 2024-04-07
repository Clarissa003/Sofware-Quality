import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.swing.*;
import java.awt.*;

import static org.mockito.Mockito.mock;

public class MenuControllerTest {

    private MenuController menuController;

    @Before
    public void setUp() {
        //System.setProperty("java.awt.headless", "true");
        Frame frameMock = mock(Frame.class);
        Presentation presentationMock = mock(Presentation.class);
        Accessor accessorMock = mock(Accessor.class);
        JOptionPane optionPaneMock = mock(JOptionPane.class);
        menuController = new MenuController(frameMock, presentationMock, accessorMock);
        menuController.setOptionPane(optionPaneMock);
    }

    //@org.junit.Test
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
    public void testClearSlideCreationRequest_ExpectTrue() {
        menuController.setNewSlideRequested(true);
        Assertions.assertTrue(menuController.isSlideCreationRequested());
    }

    @Test
    public void testClearSlideCreationRequest_ExpectFalse() {
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

}