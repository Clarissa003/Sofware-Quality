import javax.swing.*;
import java.io.IOException;

public class JabberPoint
{
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    public static void main(String argv[])
    {
        Presentation presentation = new Presentation();
        SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, presentation);

        try
        {
            if (argv.length == 0)
            { // Load demo presentation
                Accessor.getDemoAccessor().loadFile(presentation, "");
            }
            else
            { // Load custom presentation
                new XMLAccessor().loadFile(presentation, argv[0]);
            }
            presentation.setSlideNumber(0);

            // Create MenuController and set it as the menu bar for the frame
            MenuController menuController = new MenuController(frame, presentation, Accessor.getDemoAccessor ());
            frame.setMenuBar(menuController);

            // Show the frame
            frame.setVisible(true);

            // Check if new slide is requested and show create slide dialog
            if (menuController.isSlideCreationRequested())
            {
                menuController.showCreateSlideDialog();
            }

        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
