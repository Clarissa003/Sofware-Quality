import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyController extends KeyAdapter {
	private Presentation presentation;

	public KeyController(Presentation presentation) {
		this.presentation = presentation;
	}

	public void keyPressed(KeyEvent keyEvent) {
		Command command = null;

		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
			case KeyEvent.VK_T:
				command = instantiateCommand("NextCommand");
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
			case KeyEvent.VK_P:
				command = instantiateCommand("PrevCommand");
				break;
			case KeyEvent.VK_O:
				command = instantiateCommand("OpenCommand");
				break;
			case KeyEvent.VK_N:
				command = instantiateCommand("NewCommand");
				break;
			case KeyEvent.VK_S:
				command = instantiateCommand("SaveCommand");
				break;
			case KeyEvent.VK_X:
				command = instantiateCommand("ExitCommand");
				break;
			case KeyEvent.VK_G:
				command = instantiateCommand("GoToCommand");
				break;
			case KeyEvent.VK_A:
				command = instantiateCommand("AboutCommand");
				break;
			default:
				break;
		}

		if (command != null) {
			command.execute();
		}
	}

	private Command instantiateCommand(String className) {
		try {
			Class<?> commandClass = Class.forName(className);
			return (Command) commandClass.getDeclaredConstructor(Presentation.class).newInstance(presentation);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
