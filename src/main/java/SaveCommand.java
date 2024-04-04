import javax.swing.*;
import java.io.IOException;

public class SaveCommand extends Command
{
    public SaveCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(presentation, MenuController.SAVEFILE);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, MenuController.IOEX + exception, MenuController.SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
