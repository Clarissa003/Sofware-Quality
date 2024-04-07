package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PrevCommandTest
{

    @Test
    public void testExecute()
    {
        Presentation presentationMock = mock(Presentation.class);

        PrevCommand prevCommand = new PrevCommand(presentationMock);
        prevCommand.execute();

        verify(presentationMock, times(1)).prevSlide();
    }
}
