package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

import java.awt.*;

public class AboutCommand extends Command
{
    private final Frame aboutBox;

    public AboutCommand(Presentation presentation, Frame aboutBox)
    {
        super(presentation);
        this.aboutBox = aboutBox;
    }

    @Override
    public void execute()
    {
        AboutBox.show(aboutBox);
    }
}
