package com.nhlstenden.menuController;

import com.nhlstenden.menuController.Command;
import com.nhlstenden.presentation.Presentation;

public class ExitCommand extends Command
{
    public ExitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        presentation.exit(0);
    }
}
