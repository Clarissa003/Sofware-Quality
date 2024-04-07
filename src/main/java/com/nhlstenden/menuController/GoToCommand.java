package com.nhlstenden.menuController;

import com.nhlstenden.menuController.Command;
import com.nhlstenden.presentation.Presentation;

import javax.swing.*;

public class GoToCommand extends Command
{
    public GoToCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        String pageNumberString = JOptionPane.showInputDialog((Object) MenuController.PAGENR);
        int pageNumber = Integer.parseInt(pageNumberString);
        presentation.setSlideNumber(pageNumber - 1);
    }
}
