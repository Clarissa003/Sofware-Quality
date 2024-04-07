package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NextCommandTest {

    @Test
    public void testExecute() {
        Presentation presentationMock = mock(Presentation.class);

        NextCommand nextCommand = new NextCommand(presentationMock);
        nextCommand.execute();

        verify(presentationMock, times(1)).nextSlide();
    }
}
