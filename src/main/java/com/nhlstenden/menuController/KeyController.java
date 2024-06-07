package com.nhlstenden.menuController;

import com.nhlstenden.presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyController extends KeyAdapter
{
    private final Presentation presentation;

    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        Command command = null;

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
            case KeyEvent.VK_T:
                command = instantiateCommand("com.nhlstenden.menuController.NextCommand");
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
            case KeyEvent.VK_P:
                command = instantiateCommand("com.nhlstenden.menuController.PrevCommand");
                break;
            case KeyEvent.VK_O:
                command = instantiateCommand("com.nhlstenden.menuController.OpenCommand");
                break;
            case KeyEvent.VK_N:
                command = instantiateCommand("com.nhlstenden.menuController.NewCommand");
                break;
            case KeyEvent.VK_S:
                command = instantiateCommand("com.nhlstenden.menuController.SaveCommand");
                break;
            case KeyEvent.VK_X:
                command = instantiateCommand("com.nhlstenden.menuController.ExitCommand");
                break;
            case KeyEvent.VK_G:
                command = instantiateCommand("com.nhlstenden.menuController.GoToCommand");
                break;
            case KeyEvent.VK_A:
                command = instantiateCommand("com.nhlstenden.menuController.AboutCommand");
                break;
            default:
                break;
        }

        if (command != null) {
            command.execute();
        }
    }

    Command instantiateCommand(String className)
    {
        try
        {
            Class<?> commandClass = Class.forName(className);
            return (Command) commandClass.getDeclaredConstructor(Presentation.class).newInstance(presentation);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
