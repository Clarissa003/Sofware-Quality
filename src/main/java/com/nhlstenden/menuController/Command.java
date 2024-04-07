package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

public abstract class Command
{
    protected Presentation presentation;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract void execute();
}
