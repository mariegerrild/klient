package GUI;

import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;

import controller.ActionEventHandler;

import javax.swing.JButton;

import org.joda.time.DateTime;

import constants.ActionConstants;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CalendarProgram  extends JPanel{

	private ActionEventHandler actionEventHandler;
	public JLabel userWelcome;

	//public JLabel Background;
	public JButton btnLogOut;
	public JButton btnM;
    static DefaultTableModel mtblCalendar; //Table model
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    static JButton btnPrev, btnNext;
    static JLabel lblMonth, lblYear;
		  

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
		
		JLabel label = new JLabel("Uge 50");
		label.setBounds(307, 45, 131, 20);
		add(label);
		
		JButton btnTilbage = new JButton("<< Tilbage");
		btnTilbage.setBounds(133, 41, 115, 29);
		add(btnTilbage);
		
		JButton btnNste = new JButton("N\u00E6ste >>");
		btnNste.setBounds(416, 41, 115, 29);
		add(btnNste);
		
		JButton btnMandag = new JButton("Mandag");
		btnMandag.setBounds(41, 112, 94, 29);
		add(btnMandag);
		
		JButton btnTirsdag = new JButton("Tirsdag");
		btnTirsdag.setBounds(133, 112, 85, 29);
		add(btnTirsdag);
		
		JButton btnOnsdag = new JButton("Onsdag");
		btnOnsdag.setBounds(214, 112, 94, 29);
		add(btnOnsdag);
		
		JButton btnTorsdag = new JButton("Torsdag");
		btnTorsdag.setBounds(303, 112, 108, 29);
		add(btnTorsdag);
		
		JButton btnFredag = new JButton("Fredag");
		btnFredag.setBounds(404, 112, 101, 29);
		add(btnFredag);
		
		JButton btnLrdag = new JButton("L\u00F8rdag");
		btnLrdag.setBounds(499, 112, 94, 29);
		add(btnLrdag);
		
		JButton btnSndag = new JButton("S\u00F8ndag");
		btnSndag.setBounds(582, 112, 94, 29);
		add(btnSndag);

		
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
