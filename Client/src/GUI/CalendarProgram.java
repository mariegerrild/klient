package GUI;

import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ActionEventHandler;

import javax.swing.JButton;

import org.joda.time.DateTime;

import constants.ActionConstants;
import javax.swing.JLabel;

public class CalendarProgram  extends JPanel{

	private ActionEventHandler actionEventHandler;
	public JLabel userWelcome;
	
		  

	public CalendarProgram(ActionEventHandler actionEventHandler) {

		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		userWelcome = new JLabel("");
		userWelcome.setBounds(226, 21, 348, 20);
		add(userWelcome);
		
		JButton btnDayOverview = new JButton("Dagsoversigt");
		btnDayOverview.setBounds(589, 12, 123, 29);
		btnDayOverview.addActionListener( this.actionEventHandler);
		btnDayOverview.setActionCommand(ActionConstants.CalendarDay);
		add(btnDayOverview);
		
		JButton btnLogout = new JButton("Log af");
		btnLogout.setBounds(635, 316, 77, 29);
		btnLogout.addActionListener(this.actionEventHandler);
		
		
		
		btnLogout.setActionCommand(ActionConstants.Logout);
		add(btnLogout);

		
		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
	 
		   //get current date time with Calendar()
		   Calendar cal = Calendar.getInstance();
		   System.out.println(dateFormat.format(cal.getTime()));	
		
		
	}
	

	
	public DateTime getSelectedDate() {
		return DateTime.now();
	}
	public void setUserWelcome(String username) {
		userWelcome.setText("Du er logget ind som " + username);
	}
}
