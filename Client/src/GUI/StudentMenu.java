package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;


public class StudentMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu frame = new StudentMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVelkommenMarie = new JLabel("Velkommen ******");
		lblVelkommenMarie.setBounds(152, 16, 172, 20);
		contentPane.add(lblVelkommenMarie);
		
		JLabel lblKalenderMenu = new JLabel("Kalender menu");
		lblKalenderMenu.setBounds(162, 40, 133, 20);
		contentPane.add(lblKalenderMenu);
		
		JButton btnKalender = new JButton("Kalender");
		btnKalender.setBounds(152, 70, 115, 29);
		contentPane.add(btnKalender);
		
		JButton btnOpretEvent = new JButton("Opret event");
		btnOpretEvent.setBounds(152, 115, 115, 29);
		contentPane.add(btnOpretEvent);
		
		JButton btnLogUd = new JButton("Log ud");
		btnLogUd.setBounds(152, 160, 115, 29);
		contentPane.add(btnLogUd);
	}
}
