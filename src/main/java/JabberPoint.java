import com.nhlstenden.menuController.Accessor;
import com.nhlstenden.menuController.MenuController;
import com.nhlstenden.menuController.XMLAccessor;
import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.SlideViewerFrame;
import com.nhlstenden.slide.Slide;

import javax.swing.*;
import java.io.IOException;

public class JabberPoint
{
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    public static void main(String[] argv)
    {
        Presentation presentation = new Presentation();
        SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, presentation);

        try
        {
            if (argv.length == 0)
            {
                Accessor.getDemoAccessor().loadFile(presentation, "");
            } else
            {
                new XMLAccessor().loadFile(presentation, argv[0]);
            }
            presentation.setSlideNumber(0);

            MenuController menuController = new MenuController(frame, presentation, Accessor.getDemoAccessor());
            frame.setMenuBar(menuController);

            frame.setVisible(true);

            if (menuController.isSlideCreationRequested())
            {
                presentation.addObserver(() ->
                {
                    Slide newSlide = presentation.getSlide(presentation.getSize() - 1);
                    presentation.append(newSlide);
                    presentation.setSlideNumber(presentation.getSize() - 1);
                });
                menuController.showCreateSlideDialog();
            }

        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
