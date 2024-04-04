import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JabberPoint{
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";
	private Presentation presentation;


	/** Het Main Programma */
	public static void main(String argv[]) {
		Style.createStyles();
		Presentation presentation = new Presentation();
		SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, presentation);

		new SlideViewerFrame(JABVERSION, presentation);
		try {
			if (argv.length == 0) {
				buildDemoPresentation(presentation);
			} else {
				buildCustomPresentation(presentation, argv[0]);
			}
			presentation.setSlideNumber(0);

			// Create MenuController and set it as the menu bar for the frame
			MenuController menuController = new MenuController(frame, presentation);
			frame.setMenuBar(menuController);

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void buildDemoPresentation(Presentation presentation) {
		SlideDirector slideDirector = new SlideDirector(new SimplePresentationBuilder());
		SlideDirector slideDirector2 = new SlideDirector (new FancyPresentationBuilder ());

		Slide slide1 = slideDirector.createSlide ("Demo Slide 1",
				Arrays.asList(new TextItem(1, "This is the content of Demo Slide 1.")));
		Slide slide2 = slideDirector2.createSlide ("Demo Slide 2",
				Arrays.asList(new TextItem(1, "This is the content of Demo Slide 2.")));

		presentation.append(slide1);
		presentation.append(slide2);
	}

	private static void buildCustomPresentation(Presentation presentation, String xmlFilePath) throws IOException {
		new XMLAccessor().loadFile(presentation, xmlFilePath);
	}
}
