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
		setLayout(null);
		
		lblNewLabel = new JLabel("Du er nu logget ind som");
		lblNewLabel.setBounds(329, 16, 73, 20);
		add(lblNewLabel);
		
		JButton btnDayOverview = new JButton("Dagsoversigt");
		btnDayOverview.setBounds(589, 12, 123, 29);
		btnDayOverview.addActionListener( this.actionEventHandler);
		btnDayOverview.setActionCommand(ActionConstants.CalendarDay);
		add(btnDayOverview);
		
		JButton btnLogout = new JButton("Logud");
		btnLogout.setBounds(635, 316, 77, 29);
		btnLogout.addActionListener(this.actionEventHandler);
		
		
		
		btnLogout.setActionCommand(ActionConstants.Logout);
		add(btnLogout);
		
		
		
		
	}
	

	
	public DateTime getSelectedDate() {
		return DateTime.now();
	}
}
