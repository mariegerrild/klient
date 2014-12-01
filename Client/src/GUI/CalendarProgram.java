package GUI;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ActionEventHandler;

import javax.swing.JButton;

import org.joda.time.DateTime;

import constants.ActionConstants;
import javax.swing.JLabel;

public class CalendarProgram  extends JPanel{

	private ActionEventHandler actionEventHandler;
	public JLabel lblNewLabel;

	public CalendarProgram(ActionEventHandler actionEventHandler) {

		this.actionEventHandler = actionEventHandler;
		
		JButton btnLogout = new JButton("Logud");
		btnLogout.addActionListener(this.actionEventHandler);
		
		lblNewLabel = new JLabel("New Label");
		add(lblNewLabel);
		
		
		
		btnLogout.setActionCommand(ActionConstants.Logout);
		add(btnLogout);
		
		JButton btnDayOverview = new JButton("Dagsoversigt");
		btnDayOverview.addActionListener( this.actionEventHandler);
		btnDayOverview.setActionCommand(ActionConstants.CalendarDay);
		add(btnDayOverview);
		
		
		
		
	}
	

	
	public DateTime getSelectedDate() {
		return DateTime.now();
	}
}
