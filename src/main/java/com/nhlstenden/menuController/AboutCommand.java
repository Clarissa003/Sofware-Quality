package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

import javax.swing.JOptionPane;
import java.awt.Frame;

public class AboutCommand extends Command {
    private final Frame parentFrame;

    public AboutCommand(Presentation presentation, Frame parentFrame) {
        super(presentation);
        this.parentFrame = parentFrame;
    }

    @Override
    public void execute() {
        // Create an instance of JOptionPane
        JOptionPane optionPane = new JOptionPane();

        // Pass the Frame and JOptionPane to the show method of AboutBox
        AboutBox.show(parentFrame, optionPane);
    }
}
