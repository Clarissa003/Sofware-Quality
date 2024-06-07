package com.nhlstenden.menuController;

import com.nhlstenden.presentation.DemoPresentation;
import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccessorTest
{

    private Accessor demoAccessor;
    private Presentation mockPresentation;

    @BeforeEach
    public void setUp()
    {
        demoAccessor = Accessor.getDemoAccessor();
        mockPresentation = mock(Presentation.class);
    }

    @Test
    public void testGetDemoAccessor()
    {
        assertNotNull(demoAccessor);
        assertTrue(demoAccessor instanceof DemoPresentation);
    }
}
