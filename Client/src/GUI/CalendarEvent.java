package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalendarEvent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarEvent frame = new CalendarEvent();
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
	public CalendarEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDagensBegivenheder = new JLabel("Dagens begivenheder");
		lblDagensBegivenheder.setBounds(15, 37, 163, 20);
		contentPane.add(lblDagensBegivenheder);
		
		JLabel lblOpretBegivenhed = new JLabel("Opret begivenhed");
		lblOpretBegivenhed.setBounds(596, 37, 205, 20);
		contentPane.add(lblOpretBegivenhed);
		
		textField = new JTextField();
		textField.setBounds(526, 73, 275, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(526, 124, 123, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(687, 124, 114, 40);
		contentPane.add(textField_2);
		
		JLabel lblTil = new JLabel("til");
		lblTil.setBounds(662, 134, 69, 20);
		contentPane.add(lblTil);
		
		textField_3 = new JTextField();
		textField_3.setBounds(526, 180, 275, 78);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnOpretBegivenhed = new JButton("Opret begivenhed");
		btnOpretBegivenhed.setBounds(577, 279, 179, 35);
		contentPane.add(btnOpretBegivenhed);
		
		JButton button = new JButton("Slet begivenhed");
		button.setBounds(577, 330, 179, 35);
		contentPane.add(button);
		
		btnNewButton = new JButton("Tilbage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(15, 472, 161, 35);
		contentPane.add(btnNewButton);
	}

}