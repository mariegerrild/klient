package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import constants.ActionConstants;
import controller.ActionEventHandler;

import javax.swing.JLabel;

import Logic.ServerManager;
import model.Appointment;
import model.Calendar;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class CalendarDay extends JPanel{

	private ActionEventHandler actionEventHandler;
	private JLabel lbldate;
	private JLabel lblAppointments;
	private JButton btnLogOut;
	private JButton btnDayOverview;
	private JButton btnM;
	private JButton btnOpret;
	private JLabel lblEvents;
	private JTextField textFieldTitle;
	private JTextField textFieldNote;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;
	private JTextField textFieldLocation;
	private JLabel labelStatus;
	
	   
	private JPanel panelDates;
	private JButton btnVejr;
	private JButton btnVejr_1;
	private JLabel lblOpretBegivenhed;
	  

	public CalendarDay(ActionEventHandler actionEventHandler) {
		
		setLayout(null);
		
		this.actionEventHandler = actionEventHandler;
		
		
		labelStatus = new JLabel("");
		labelStatus.setBounds(375, 323, 192, 16);
		labelStatus.setForeground(Color.black);
		add(labelStatus);
		
		btnOpret = new JButton("Opret");
		btnOpret.setBounds(582, 310, 117, 29);
		btnOpret.addActionListener( this.actionEventHandler);
		btnOpret.setActionCommand(ActionConstants.CreateEvent);
		add(btnOpret);
		
		textFieldLocation = new JTextField("");
		textFieldLocation.setBounds(572,264,134,28);
		add(textFieldLocation);
		
		textFieldEndDate = new JTextField("");
		textFieldEndDate.setBounds(572, 186, 134, 28);
		add(textFieldEndDate);
		
		textFieldStartDate = new JTextField("");
		textFieldStartDate.setBounds(572, 146, 134, 28);
		add(textFieldStartDate); 
		
		textFieldNote = new JTextField("");
		textFieldNote.setBounds(572, 226, 134, 28);
		add(textFieldNote);
		
		
		textFieldTitle = new JTextField("");
		textFieldTitle.setBounds(572, 106, 134, 28);
		add(textFieldTitle);
		
		
		btnDayOverview = new JButton("Kalendaroversigt");
		btnDayOverview.setBounds(557, 22, 149, 29);
		btnDayOverview.addActionListener( this.actionEventHandler);
		btnDayOverview.setActionCommand(ActionConstants.CalendarProgram);
		add(btnDayOverview);
		
		
		
		//add(lblEvents);
		
		panelDates = new JPanel();
		panelDates.setBounds(68, 79, 419, 213);
		panelDates.setLayout(new BoxLayout(panelDates, BoxLayout.PAGE_AXIS));
		panelDates.setOpaque(false);
		add(panelDates);
	
		lbldate = new JLabel("");
		lbldate.setBounds(299, 19, 0, 0);
		add(lbldate);
		
		lblAppointments = new JLabel("Dagens begivenheder");
		lblAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointments.setForeground(Color.black);
		lblAppointments.setBounds(-200, 19, 728, 33);
		add(lblAppointments);
	
		
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log af");
		btnLogOut.setBounds(53, 310, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(ActionConstants.Logout);
		add(btnLogOut);
		
		JLabel lblTitle_1 = new JLabel("Title");
		lblTitle_1.setBounds(488, 110, 69, 20);
		add(lblTitle_1);
		
		JLabel lblStartDato = new JLabel("Start dato");
		lblStartDato.setBounds(488, 150, 69, 20);
		add(lblStartDato);
		
		JLabel lblSlutDato = new JLabel("Slut dato");
		lblSlutDato.setBounds(488, 194, 69, 20);
		add(lblSlutDato);
		
		JLabel lblNote_1 = new JLabel("Note");
		lblNote_1.setBounds(488, 234, 69, 20);
		add(lblNote_1);
		
		JLabel label = new JLabel("Lokation");
		label.setBounds(488, 268, 103, 20);
		add(label);
		
		btnVejr = new JButton("Vejr");
		btnVejr.setBounds(184, 310, 115, 29);
		add(btnVejr);
		
		btnVejr_1 = new JButton("QOTD");
		btnVejr_1.setBounds(312, 310, 115, 29);
		add(btnVejr_1);
		
		lblOpretBegivenhed = new JLabel("Opret begivenhed");
		lblOpretBegivenhed.setBounds(572, 70, 127, 20);
		add(lblOpretBegivenhed);
		
	}
	

	public void setDailyEve(String username)
	
	{

		lblEvents.setText(username);
			
	}
	
	public void setLblEvents(Calendar[] calendars) {
				
		for(int i = 0; i< calendars.length; i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel lblTitle = new JLabel("Title:"+calendars[i].getTitle());
			panel.add(lblTitle);
			JLabel lblDate = new JLabel("Date:"+calendars[i].getStartDate()+" to "+calendars[i].getEndDate());
			panel.add(lblDate);
			JLabel lblNote = new JLabel("Note:"+calendars[i].getNote());
			panel.add(lblNote);
			JLabel lblLocation = new JLabel("Location:"+calendars[i].getLocation());
			panel.add(lblLocation);
			panelDates.add(panel);
		}		
	} 
	
	public String getTitle() {
		return textFieldTitle.getText();
	}
	public String getNote() {
		return textFieldNote.getText();
	}
	public String getStartDate() {

		return textFieldStartDate.getText();

	}
	public String getEndDate()  {
		return textFieldEndDate.getText();
	}
	
	public String getLokation() {
		return textFieldLocation.getText();
	}

	public void setStatus(String message) {
		labelStatus.setText(message);
	}
	public void setUserEvents(String events){
		lblEvents.setText(events);
	}
}