package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

public class PrevCommand extends Command
{
    public PrevCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        presentation.prevSlide();
    }
}
