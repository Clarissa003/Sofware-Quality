package com.nhlstenden.menuController;

import com.nhlstenden.menuController.Command;
import com.nhlstenden.menuController.MenuController;
import com.nhlstenden.presentation.Presentation;

import javax.swing.*;
import java.io.IOException;

public class OpenCommand extends Command
{
    public OpenCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        presentation.clear();;
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(presentation, MenuController.TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, MenuController.IOEX + exception, MenuController.LOADERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
