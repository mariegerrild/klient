package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.ServerManager;
import constants.ActionConstants;
import constants.ViewConstants;
import GUI.Screen;
public class ActionEventHandler implements ActionListener {
	/** The calendar controller. */
	private CalendarController calendarController;
	
	/** The screen. */
	private Screen screen;
	/**
	 * Instantiates a new action event handler.
	 *
	 * @param atmController the atm controller
	 * @param screen the screen
	 */
	public ActionEventHandler(CalendarController calendarController, Screen screen) {
		this.calendarController = calendarController;
		this.screen = screen;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Find the actions id, as a different ActionCommand is set for each functionality
		String cmd = e.getActionCommand();
		if (cmd.equals(ActionConstants.Login)) {
			/* 
			String inputUsername = textField.getText();
        	 String inputPassword = textField_1.getText();
        	 try {
				String loginResult = ServerManager.Login(inputUsername, inputPassword);
				labelResult.setText(loginResult);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				labelResult.setText(e1.getMessage());
			} */
			//screen.show(ViewConstants.CalendarOverview);
		}
		else if(cmd.equals(ActionConstants.Logout)){
			screen.show(ViewConstants.Login);
		}
	//	else if(cmd.equals(ActionConstants.CalendarDay)){
		//	screen.show(ViewConstants.CalendarDay);
		}
		//else if(cmd.equals(ActionConstants.CalendarOverview)){
			//screen.show(ViewConstants.CalendarOverview);
	//	}
	//}
}