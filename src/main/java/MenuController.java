import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
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

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;
		setupMenus();
	}

	private void setupMenus() {
		MenuItem menuItem;

		Menu fileMenu = new Menu("File");
		fileMenu.add(createMenuItem("Open", new OpenCommand(presentation), KeyEvent.VK_O));
		fileMenu.add(createMenuItem("New", new NewCommand(presentation), KeyEvent.VK_N));
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


	// create a menu item
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
