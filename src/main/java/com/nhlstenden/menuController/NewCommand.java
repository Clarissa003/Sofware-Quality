package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

public class NewCommand extends Command
{
    private final MenuController menuController;

    public NewCommand(Presentation presentation, MenuController menuController)
    {
        super(presentation);
        this.menuController = menuController;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        menuController.setNewSlideRequested(true);
        menuController.showCreateSlideDialog();
        presentation.setSlideNumber(presentation.getSize() - 1);
    }
}
