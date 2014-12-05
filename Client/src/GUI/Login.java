package GUI;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
	private JTextField txtIndtastCbsEmail;
	private JLabel labelResult;
	private JLabel lblAdgangskode;
	private JButton btnNewButton;
	private JTextField txtIndtastPassword;
	

	


	public Login(ActionEventHandler actionEventHandler, FocusListener focusListener) {

		this.actionEventHandler = actionEventHandler;
			setLayout(null);


			
			JLabel lblNewLabel = new JLabel("Velkommen til CBS calendar");
			lblNewLabel.setBounds(164, 27, 438, 39);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			add(lblNewLabel);
			
			
			btnNewButton = new JButton("OK");
			btnNewButton.setBounds(329, 210, 117, 39);
			btnNewButton.addActionListener( this.actionEventHandler);
			btnNewButton.setActionCommand(ActionConstants.Login);
			add(btnNewButton);
			
			labelResult = new JLabel();
			labelResult.setBounds(318, 265, 134, 28);
			add(labelResult);
			
			JLabel lblEmail = new JLabel("e-mail");
			lblEmail.setBounds(259, 91, 58, 20);
			add(lblEmail);
			
		//	text promt on a JTextField using FocusListener
		txtIndtastCbsEmail = new JTextField();
		txtIndtastCbsEmail.setText("Indsæt e-mail");
		txtIndtastCbsEmail.setBounds(318, 82, 134, 39);
		add(txtIndtastCbsEmail);
		txtIndtastCbsEmail.addFocusListener(new FocusAdapter(){
			
			public void focusGained(FocusEvent e){
				txtIndtastCbsEmail.setText("");
			}
			public void focusLost(FocusEvent e){
				if (txtIndtastCbsEmail.getText().equals("")){
					txtIndtastCbsEmail.setText("Enter e-mail");
				}
		}
	});
		
		txtIndtastPassword = new JTextField();
		txtIndtastPassword.setText(" Indsæt password");
		txtIndtastPassword.setBounds(318, 137, 134, 39);
		add(txtIndtastPassword);
		
		JLabel lblAdgangskode_1 = new JLabel("adgangskode");
		lblAdgangskode_1.setBounds(216, 146, 101, 20);
		add(lblAdgangskode_1);
		txtIndtastPassword.addFocusListener(new FocusAdapter(){
			
			public void focusGained(FocusEvent e){
				txtIndtastPassword.setText("");
			}
			public void focusLost(FocusEvent e){
				if (txtIndtastPassword.getText().equals("")){
					txtIndtastPassword.setText(" Indsæt password");
				}
		}
	});


		
	}

		public String getUserName() {
			return txtIndtastCbsEmail.getText();
		}
		
		public String getPassword() {
			return txtIndtastPassword.getText();
		}
		
		public void setStatus(String message) {
			labelResult.setText(message);
		}
		
		public void resetView(){
			labelResult.setText("");
			txtIndtastCbsEmail.setText("");
			txtIndtastPassword.setText("");
		}
}
		

