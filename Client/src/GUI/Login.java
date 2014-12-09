package GUI;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ActionEventHandler;

import javax.swing.JButton;

import constants.ActionConstants;

import java.awt.Color;
import java.awt.Font;

public class Login extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ActionEventHandler actionEventHandler;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUserName;
	private JLabel labelStatus;
	private JButton btnLogin;
	private JLabel lblEnterDetails;
	private JLabel Background;
	private JLabel lblEnterEmail;
	private JLabel lblIndtastEmail;
	private JLabel lblAdgangskode;

	
	  
	
	
	public Login(ActionEventHandler actionEventHandler) {
		
		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		labelStatus = new JLabel("");
		labelStatus.setBounds(300, 241, 124, 16);
		labelStatus.setForeground(Color.black);
		add(labelStatus);
		
	
		// Swing components
		
		lblEnterDetails = new JLabel("Indtast dine informationer");
		lblEnterDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails.setBounds(0, 52, 721, 16);
		lblEnterDetails.setForeground(Color.black);
		add(lblEnterDetails);
		
		lblEnterEmail = new JLabel();
		lblEnterEmail.setBounds(288, 19, 0, 0);
		lblEnterEmail.setForeground(Color.black);
		add(lblEnterEmail);
		
		
		btnLogin = new JButton("Log ind");
		btnLogin.setBounds(311, 200, 91, 29);
		btnLogin.addActionListener( this.actionEventHandler);
		btnLogin.setActionCommand(ActionConstants.Login);
		add(btnLogin);
		
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(290, 100, 134, 28);
		textFieldUserName.setToolTipText("Password");
		textFieldUserName.setColumns(10);
		add(textFieldUserName);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(290, 145, 134, 28);
		textFieldPassword.setToolTipText("Email");
		textFieldPassword.setColumns(10);
		add(textFieldPassword);
		
		lblIndtastEmail = new JLabel("Indtast e-mail");
		lblIndtastEmail.setBounds(166, 104, 108, 20);
		add(lblIndtastEmail);
		
		lblAdgangskode = new JLabel("adgangskode");
		lblAdgangskode.setBounds(166, 149, 109, 20);
		add(lblAdgangskode);
		
	}

	public String getUserName() {
		return textFieldUserName.getText();
	}
	
	public String getPassword() {
		return textFieldPassword.getText();
	}
	
	public void setStatus(String message) {
		labelStatus.setText(message);
	}
	
	public void resetView(){
		labelStatus.setText("");
		textFieldPassword.setText("");
		textFieldUserName.setText("");
	}
}