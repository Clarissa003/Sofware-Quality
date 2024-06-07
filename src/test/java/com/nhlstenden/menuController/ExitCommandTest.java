package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ExitCommandTest
{
    private Presentation presentation;
    private ExitCommand exitCommand;

    @BeforeEach
    void setUp()
    {
        presentation = mock(Presentation.class);
        exitCommand = new ExitCommand(presentation);
    }

    @Test
    void execute()
    {
        exitCommand.execute();
        verify(presentation, times(1)).exit(0);
    }
}
