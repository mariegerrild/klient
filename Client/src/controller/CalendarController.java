package controller;
import javax.swing.JFrame;
import constants.ViewConstants;
import GUI.Screen;
public class CalendarController {
	/** The screen. */
	private Screen screen;
	
	public CalendarController() {
		this.screen = new Screen(this);
	}
	public void run() {
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		screen.setLocationRelativeTo(null);
		screen.show(ViewConstants.Login);
	}
}
