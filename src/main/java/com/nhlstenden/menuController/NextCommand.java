package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

public class NextCommand extends Command
{
    public NextCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        presentation.nextSlide();
    }
}
