import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuController extends MenuBar {

	private Frame parent;
	private Presentation presentation;

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;
		MenuItem menuItem;
		Menu fileMenu = new Menu("File");
		fileMenu.add(menuItem = mkMenuItem("Open"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();
				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.loadFile(presentation, "test.xml");
					presentation.setSlideNumber(0);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, "IO Exception: " + exc,
							"Load Error", JOptionPane.ERROR_MESSAGE);
				}
				parent.repaint();
			}
		});
		fileMenu.add(menuItem = mkMenuItem("New"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				showCreateSlideDialog();
			}
		});
		fileMenu.add(menuItem = mkMenuItem("Save"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.saveFile(presentation, "dump.xml");
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, "IO Exception: " + exc,
							"Save Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem("Exit"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.exit(0);
			}
		});
		add(fileMenu);

		Menu viewMenu = new Menu("View");
		viewMenu.add(menuItem = mkMenuItem("Next"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.nextSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem("Previous"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.prevSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem("Go To"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog(parent, "Enter slide number:");
				if (pageNumberStr != null && !pageNumberStr.trim().isEmpty()) {
					try {
						int pageNumber = Integer.parseInt(pageNumberStr);
						if (pageNumber >= 1 && pageNumber <= presentation.getSize()) {
							presentation.setSlideNumber(pageNumber - 1);
						} else {
							JOptionPane.showMessageDialog(parent, "Invalid slide number.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(parent, "Invalid input. Please enter a valid slide number.",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add(viewMenu);

		Menu helpMenu = new Menu("Help");
		helpMenu.add(menuItem = mkMenuItem("About"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(parent);
			}
		});
		setHelpMenu(helpMenu);
	}

	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}

	private void showCreateSlideDialog() {
		// Prompt for slide title
		String title = JOptionPane.showInputDialog(parent, "Enter slide title:");
		if (title == null || title.trim().isEmpty()) {
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

		// Create a slide based on user input
		Slide slide;
		if (shouldCreateFancySlide()) {
			SlideDirector slideDirector = new SlideDirector(new FancyPresentationBuilder());
			slide = slideDirector.createSlide(title, slideItems);
		} else {
			SlideDirector slideDirector = new SlideDirector(new SimplePresentationBuilder());
			slide = slideDirector.createSlide(title, slideItems);
		}

		// Append the slide to the presentation
		presentation.append(slide);

		// Repaint the frame
		parent.repaint();
	}

	private boolean shouldCreateFancySlide() {
		int choice = JOptionPane.showConfirmDialog(parent, "Create Fancy Slide?", "Choose Slide Type",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return choice == JOptionPane.YES_OPTION;
	}
}
