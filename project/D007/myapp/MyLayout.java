package myapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class MyLayout extends JFrame {

	private JPanel contentPane;
	private int flag = 0;
	private JTextField txtEnterEmail;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLayout frame = new MyLayout();
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
	public MyLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 318);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(loginHandle() == false) {
					passwordField.requestFocus();
				}
			}
		});
		
		txtEnterEmail.setBounds(199, 88, 168, 20);
		contentPane.add(txtEnterEmail);
		txtEnterEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(196, 66, 49, 14);
		contentPane.add(lblEmail);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginHandle() == false) {
					txtEnterEmail.requestFocus();
				}
			}
		});
		passwordField.setBounds(199, 140, 168, 20);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(196, 119, 73, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Login Handle Here
				loginHandle();
			}
		});
		btnLogin.setBounds(278, 171, 89, 23);
		contentPane.add(btnLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(199, 11, 168, 14);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * Login Handle
	 */
	protected Boolean loginHandle() {
		String email = txtEnterEmail.getText();
		String password = passwordField.getText();
		if(!email.isEmpty() && !password.isEmpty()) {
			System.out.print(2);
			lblNewLabel.setText(email + "/" + password);
			return true;
		}
		
		return false;
	}
}
