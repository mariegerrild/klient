package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.joda.time.DateTime;

import Logic.ServerManager;
import model.User;
import constants.ActionConstants;
import constants.ViewConstants;
import GUI.CalendarProgram;
import GUI.Login;
import GUI.Screen;
import GUI.CalendarDay;

public class ActionEventHandler implements ActionListener {
	/** The calendar controller. */
	private CalendarController calendarController;
	
	/** The screen. */
	private Screen screen;

	private User currentUser;
	

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
			
			String username = screen.getLoginView().getUserName();
			String password = screen.getLoginView().getPassword();
			
			try {
				screen.setCurrentUser(ServerManager.Login(username, password));
				screen.show(ViewConstants.CalendarProgram);
				screen.getCalendarProgram().setUserWelcome(username);
			} catch (Exception e1) {
				screen.getLoginView().setStatus(e1.getMessage());
			}		
		}
		else if(cmd.equals(ActionConstants.Logout)){
			screen.getLoginView().resetView();
			screen.setCurrentUser(null);
			
			screen.show(ViewConstants.Login);
		}
		else if(cmd.equals(ActionConstants.CalendarDay)){
			DateTime date = screen.getCalendarProgram().getSelectedDate();
			
			screen.getCalendarDay().setSelectedDate(date);
			
			screen.show(ViewConstants.CalendarDay);
		}
		else if(cmd.equals(ActionConstants.CalendarProgram)){
			screen.show(ViewConstants.CalendarProgram);
		}
		
		
	}

	public User getCurrentUser() {
		return currentUser;
	}
	
}