package com.nhlstenden.menuController;

import com.nhlstenden.menuController.Command;
import com.nhlstenden.menuController.MenuController;
import com.nhlstenden.presentation.Presentation;

import javax.swing.*;
import java.io.IOException;

public class SaveCommand extends Command
{
    public SaveCommand(Presentation presentation)
    {
        super(presentation);

    }

    //Call save method from xmlAccessor
    @Override
    public void execute()
    {
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.saveFile(presentation, MenuController.SAVEFILE);
        } catch (IOException exception)
        {
            JOptionPane.showMessageDialog(null, MenuController.IOEX + exception, MenuController.SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
