package GUI;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ActionEventHandler;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Logic.ServerManager;
import constants.ActionConstants;

public class Login extends JFrame {
	
	private ActionEventHandler actionEventHandler;

	public Login(ActionEventHandler actionEventHandler) {

		this.actionEventHandler = actionEventHandler; }
		
		
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JLabel labelResult;
		private JLabel lblAdgangskode;

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
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Velkommen til CBS");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(6, 10, 438, 39);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setToolTipText("Email");
			textField.setBounds(149, 82, 134, 28);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setToolTipText("Password");
			textField_1.setBounds(149, 137, 134, 28);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnNewButton = new JButton("OK");
			btnNewButton.setBounds(159, 187, 117, 29);
			contentPane.add(btnNewButton);
			
			labelResult = new JLabel();
			labelResult.setBounds(149, 210, 134, 28);
			contentPane.add(labelResult);
			
			JLabel lblEmail = new JLabel("e-mail");
			lblEmail.setBounds(76, 86, 69, 20);
			contentPane.add(lblEmail);
			
			lblAdgangskode = new JLabel("Adgangskode");
			lblAdgangskode.setBounds(31, 141, 103, 20);
			contentPane.add(lblAdgangskode);
			
			btnNewButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 String inputUsername = textField.getText();
		        	 String inputPassword = textField_1.getText();
		        	 try {
						String loginResult = ServerManager.Login(inputUsername, inputPassword);
						labelResult.setText(loginResult);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						labelResult.setText(e1.getMessage());
					} 
		        	 
		         }          
		      });
		
	}
}
		

