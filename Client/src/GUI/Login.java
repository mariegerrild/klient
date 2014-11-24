package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_341328425981904");
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 79, 146, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 121, 146, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblVelkommenTilCbs = new JLabel("Velkommen til CBS");
		lblVelkommenTilCbs.setBounds(152, 16, 141, 20);
		panel.add(lblVelkommenTilCbs);
		
		JLabel lblIndtastDineOplysninger = new JLabel("Indtast dine oplysninger");
		lblIndtastDineOplysninger.setBounds(145, 43, 215, 20);
		panel.add(lblIndtastDineOplysninger);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(68, 82, 69, 20);
		panel.add(lblEmail);
		
		JLabel lblAdgangskode = new JLabel("Adgangskode");
		lblAdgangskode.setBounds(46, 124, 111, 20);
		panel.add(lblAdgangskode);
	}
}
