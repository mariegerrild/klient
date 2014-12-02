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
	
	  
	public CalendarDay(ActionEventHandler actionEventHandler) {

		this.actionEventHandler = actionEventHandler;
		
		Font italicFont = new Font("", Font.ITALIC | Font.PLAIN, 20);
		   Font boldFont = new Font("", Font.BOLD | Font.PLAIN, 20);
		   Font plainFont = new Font("", Font.PLAIN | Font.PLAIN, 20);
		
		
		btnDayOverview = new JButton("Kalenderoversigt");
		btnDayOverview.setBounds(15, 19, 149, 29);
		btnDayOverview.addActionListener( this.actionEventHandler);
		setLayout(null);
		btnDayOverview.setActionCommand(ActionConstants.CalendarProgram);
		add(btnDayOverview);
		
		lbldate = new JLabel("");
		lbldate.setBounds(299, 19, 0, 0);
		add(lbldate);
		
		lblAppointments = new JLabel("Dagens begivenheder");
		lblAppointments.setBounds(0, 10, 753, 44);
		lblAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointments.setForeground(Color.grey);
		lblAppointments.setFont(boldFont);
		add(lblAppointments);
		

		
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log af");
		btnLogOut.setBounds(596, 356, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(ActionConstants.Logout);
		add(btnLogOut);
				
		
		
	}
	
	public void setSelectedDate(DateTime date) {
		selectedDate=date;
		
		Appointment[] appointments = ServerManager.getAppointments(date);
		
		lbldate.setText("Dato: "+ selectedDate);
	}
}


