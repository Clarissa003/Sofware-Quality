import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SlideViewerFrame extends JFrame {
	private Presentation presentation;
	private SlideViewerComponent slideViewerComponent;

	public SlideViewerFrame(String title, Presentation presentation) {
		super(title);
		this.presentation = presentation;
		setupWindow();
	}

	private void setupWindow() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		slideViewerComponent = new SlideViewerComponent(presentation, this);
		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyController(presentation));
		setMenuBar(new MenuController(this, presentation));
		setSize(new Dimension(1200, 800)); // Set sizes as needed
		setVisible(true);
	}

	// Notify Presentation
	public void notifyPresentation() {
		if (presentation != null) {
			presentation.update(this.presentation);
		}
	}
}
