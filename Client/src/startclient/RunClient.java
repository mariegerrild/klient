package startclient;

import controller.CalendarController;


public class RunClient {
	
	public static void main(String[] args) {
		
		CalendarController calendarController = new CalendarController();
		//Run the program
		calendarController.run();
	}

}