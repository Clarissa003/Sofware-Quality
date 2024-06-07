package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

import javax.swing.JOptionPane;
import java.awt.Frame;

public class AboutCommand extends Command
{
    private final Frame parentFrame;

    public AboutCommand(Presentation presentation, Frame parentFrame)
    {
        super(presentation);
        this.parentFrame = parentFrame;
    }

    @Override
    public void execute()
    {
        JOptionPane optionPane = new JOptionPane();

        AboutBox.show(parentFrame, optionPane);
    }
}
