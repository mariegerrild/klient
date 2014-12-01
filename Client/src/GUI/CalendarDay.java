package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import constants.ActionConstants;
import controller.ActionEventHandler;

import javax.swing.JLabel;

import Logic.ServerManager;
import model.Appointment;

import javax.swing.SwingConstants;

public class CalendarDay extends JPanel{

	private ActionEventHandler actionEventHandler;
	private DateTime selectedDate;
	private JLabel lbldate;
	private JLabel Background;
	private JLabel lblAppointments;
	private JButton btnLogOut;
	private JButton btnDayOverview;
	private JButton btnM;
	
	   Font italicFont = new Font("Helvetica Neue", Font.ITALIC | Font.PLAIN, 14);
	   Font boldFont = new Font("Helvetica Neue", Font.BOLD | Font.PLAIN, 16);
	   Font plainFont = new Font("Helvetica Neue", Font.PLAIN | Font.PLAIN, 14);

	public CalendarDay(ActionEventHandler actionEventHandler) {
		
		setLayout(null);

		this.actionEventHandler = actionEventHandler;
		
		
		btnDayOverview = new JButton("Kalendaroversigt");
		btnDayOverview.setBounds(289, 11, 149, 29);
		btnDayOverview.addActionListener( this.actionEventHandler);
		btnDayOverview.setActionCommand(ActionConstants.CalendarProgram);
		add(btnDayOverview);
		
		lbldate = new JLabel("");
		lbldate.setBounds(299, 19, 0, 0);
		add(lbldate);
		
		lblAppointments = new JLabel("Dine aftaler for i dag");
		lblAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointments.setForeground(Color.white);
		lblAppointments.setFont(boldFont);
		lblAppointments.setBounds(0, 73, 728, 16);
		add(lblAppointments);
		

		
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log af");
		btnLogOut.setBounds(605, 11, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(ActionConstants.Logout);
		add(btnLogOut);
				
		Background = new JLabel("");
		Background.setIcon(new ImageIcon("res/img/MainMenubg.png"));
		Background.setBounds(0, 0, 728, 400);
		add(Background);
				
		
	}
	
	public void setSelectedDate(DateTime date) {
		selectedDate=date;
		
		Appointment[] appointments = ServerManager.getAppointments(date);
		
		lbldate.setText("Dato: "+ selectedDate);
	}
}


