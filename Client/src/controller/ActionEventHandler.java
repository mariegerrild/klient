package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import Logic.ServerManager;
import model.Appointment;
import model.Calendar;
import model.User;
import constants.ActionConstants;
import constants.ViewConstants;
import GUI.CalendarProgram;
import GUI.CalendarDay;
import GUI.Login;
import GUI.Screen;

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
			
			String userName = screen.getLoginView().getUserName();
			try {	
				Calendar[] calendars = ServerManager.RequestCalendar(userName);
				screen.getCalendarDay().setLblEvents(calendars);
				
			} catch (Exception e1) {
				screen.getCalendarDay().setStatus(e1.getMessage());
			}
			
			
			
			screen.show(ViewConstants.CalendarDay);
		}
		else if(cmd.equals(ActionConstants.CalendarProgram)){
			screen.show(ViewConstants.CalendarProgram);
		}

		else if(cmd.equals(ActionConstants.CreateEvent)){
			
			
			String titel = screen.getCalendarDay().getTitle();
			String note = screen.getCalendarDay().getNote();
			String lokation = screen.getCalendarDay().getLokation();
			String startDate = screen.getCalendarDay().getStartDate();
			String endDate = screen.getCalendarDay().getEndDate();
			String userName = screen.getLoginView().getUserName();
			try {		
				screen.setDailyEvents(ServerManager.CreateCalendar(titel, startDate, endDate, note, lokation, userName));
			} catch (Exception e1) {
				screen.getCalendarDay().setStatus(e1.getMessage());
			}
			
			
		}
		
	}

	public User getCurrentUser() {
		return currentUser;
	}
}