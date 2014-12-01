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

public class Login extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ActionEventHandler actionEventHandler;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel labelResult;
	private JLabel lblAdgangskode;
	private JButton btnNewButton;

	


	public Login(ActionEventHandler actionEventHandler) {

		this.actionEventHandler = actionEventHandler; 
		setLayout(null);


			
			JLabel lblNewLabel = new JLabel("Velkommen til CBS");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(164, 27, 438, 39);
			add(lblNewLabel);
			
			textField = new JTextField();
			textField.setToolTipText("Email");
			textField.setBounds(318, 82, 134, 28);
			add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setToolTipText("Password");
			textField_1.setBounds(318, 137, 134, 28);
			add(textField_1);
			textField_1.setColumns(10);
			
			btnNewButton = new JButton("OK");
			btnNewButton.setBounds(329, 210, 117, 29);
			btnNewButton.addActionListener( this.actionEventHandler);
			btnNewButton.setActionCommand(ActionConstants.Login);
			add(btnNewButton);
			
			labelResult = new JLabel();
			labelResult.setBounds(149, 210, 134, 28);
			add(labelResult);
			
			JLabel lblEmail = new JLabel("e-mail");
			lblEmail.setBounds(234, 90, 69, 20);
			add(lblEmail);
			
			lblAdgangskode = new JLabel("Adgangskode");
			lblAdgangskode.setBounds(178, 141, 103, 20);
			add(lblAdgangskode);
			
			
		
	}

		public String getUserName() {
			return textField.getText();
		}
		
		public String getPassword() {
			return textField_1.getText();
		}
		
		public void setStatus(String message) {
			labelResult.setText(message);
		}
		
		public void resetView(){
			labelResult.setText("");
			textField_1.setText("");
			textField.setText("");
		}
		
}
		

