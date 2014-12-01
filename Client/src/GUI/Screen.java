package GUI;
import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import constants.ViewConstants;
import controller.ActionEventHandler;
import controller.CalendarController;
/**
 * The Class Screen.
 */
public class Screen extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Windows properties
	/** The Constant WIDTH. */
	public static final int WIDTH = 728;
	
	/** The Constant HEIGHT. */
	public static final int HEIGHT = 400;
	
	//Declare our JPanels
	///** The action event handler. */
	//private ActionEventHandler actionEventHandler;
	
	/** The login. */ // login
	private Login login;
	
	private CalendarProgram calendarProgram;
	
	private CalendarDay calendarDay;
	
	private model.User currentUser;
	
	/** The root panel. */
	private JPanel rootPanel;

	private ActionEventHandler actionEventHandler;
	
	/** The c. */
	CardLayout c;
	
	public Screen(CalendarController calendarController)
	{

		//Add the properties to the windows
		setTitle("Kalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		
		rootPanel = new JPanel();
		rootPanel.setLayout(new CardLayout(0,0));
		
		//Initiate a new actionEventHandler
		this.actionEventHandler = new ActionEventHandler(calendarController, this);
		
		//Instanser af JPanels
		calendarProgram = new CalendarProgram(actionEventHandler);
		login = new Login(actionEventHandler);
		calendarDay = new CalendarDay(actionEventHandler);
		
				
		//Add the panels to the rootPanel
		rootPanel.add(calendarProgram, ViewConstants.CalendarProgram);
		rootPanel.add(login, ViewConstants.Login);
		rootPanel.add(calendarDay, ViewConstants.CalendarDay);
	
		
		setContentPane(rootPanel);
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	/**
	 * Gets the mouse event handler.
	 *
	 * @return the mouse event handler
	 */
	public ActionEventHandler getActionEventHandler() {
		return actionEventHandler;
	}
	
	/**
	 * Sets the action event handler.
	 *
	 * @param actionEventHandler the new action event handler
	 */
	public void setActionEventHandler(ActionEventHandler actionEventHandler) {
		this.actionEventHandler = actionEventHandler;
	}
	
	public void show(String card) {
		c.show(rootPanel,  card);
	}
	
	public Login getLoginView(){
		return login;
	}
	

	public CalendarProgram getCalendarProgram() {
		
		return calendarProgram;
	}

	public CalendarDay getCalendarDay() {

		return calendarDay;
	}

	public model.User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(model.User currentUser) {
		this.currentUser = currentUser;
	}
}