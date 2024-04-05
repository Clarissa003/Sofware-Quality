import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class MenuController extends MenuBar {
	private Frame parent; // the frame, only used as parent for the Dialogs
	private Presentation presentation; // Commands are given to the presentation

	private static final long serialVersionUID = 227L;
	protected static final String FILE = "File";
	protected static final String PAGENR = "Page number?";
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";

	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";
	private boolean newSlideRequested = false;

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;
		setupMenus();
	}

	private void setupMenus() {
		Menu fileMenu = new Menu("File");
		fileMenu.add(createMenuItem("Open", new OpenCommand(presentation), KeyEvent.VK_O));
		fileMenu.add(createMenuItem("New", new NewCommand(presentation, this), KeyEvent.VK_N));
		fileMenu.add(createMenuItem("Save", new SaveCommand(presentation), KeyEvent.VK_S));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Exit", new ExitCommand(presentation), KeyEvent.VK_X));

		add(fileMenu);

		Menu viewMenu = new Menu("View");
		viewMenu.add(createMenuItem("Next", new NextCommand(presentation), KeyEvent.VK_N));
		viewMenu.add(createMenuItem("Prev", new PrevCommand(presentation), KeyEvent.VK_P));
		viewMenu.add(createMenuItem("Go to", new GoToCommand(presentation), KeyEvent.VK_G));

		add(viewMenu);

		Menu helpMenu = new Menu("Help");
		helpMenu.add(createMenuItem("About", new AboutCommand(presentation, parent), KeyEvent.VK_A));

		setHelpMenu(helpMenu);
	}

	private MenuItem createMenuItem(String name, final Command command, int keyCode) {
		MenuItem menuItem = new MenuItem(name);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				command.execute();
			}
		});
		menuItem.setShortcut(new MenuShortcut(keyCode));
		return menuItem;
	}

	public boolean isSlideCreationRequested() {
		return newSlideRequested;
	}

	public void clearSlideCreationRequest() {
		newSlideRequested = false;
	}

	public void setNewSlideRequested(boolean requested) {
		newSlideRequested = requested;
	}

	public void showCreateSlideDialog() {
		if (!newSlideRequested) {
			return; // New slide not requested, do nothing
		}

		// Prompt for slide title
		String title = JOptionPane.showInputDialog(parent, "Enter slide title:");
		if (title == null || title.trim().isEmpty()) {
			clearSlideCreationRequest();
			return; // Cancelled or empty title, do nothing
		}

		// Prompt for slide content
		String content;
		StringBuilder allContent = new StringBuilder();
		do {
			content = JOptionPane.showInputDialog(parent, "Enter slide content (empty line to finish):");
			if (content != null && !content.isEmpty()) {
				allContent.append(content).append("\n");
			}
		} while (content != null && !content.isEmpty());

		// Create a list with just the text content as SlideItem
		List<SlideItem> slideItems = new ArrayList<>();
		slideItems.add(new TextItem(1, allContent.toString().trim()));

		// Determine if the user wants a fancy slide
		boolean createFancySlide = shouldCreateFancySlide();

		// Create the new slide using the appropriate SlideDirector
		SlideDirector slideDirector;
		if (createFancySlide) {
			slideDirector = new SlideDirector(new FancyPresentationBuilder());
		} else {
			slideDirector = new SlideDirector(new SimplePresentationBuilder());
		}

		// Create the slide with the provided title and content
		Slide newSlide = slideDirector.createSlide(title, slideItems);

		// Add the new slide to the existing presentation
		presentation.append(newSlide);

		// Notify observers (like SlideViewerComponent) that the presentation has changed
		presentation.notifyObservers();

		// Clear the slide creation request
		clearSlideCreationRequest();
	}

	private boolean shouldCreateFancySlide() {
		int choice = JOptionPane.showConfirmDialog(parent, "Create Fancy Slide?", "Choose Slide Type",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return choice == JOptionPane.YES_OPTION;
	}
}
