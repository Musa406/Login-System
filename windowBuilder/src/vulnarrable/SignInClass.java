package vulnarrable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignInClass {
	File file = new File("information.txt");
	

	private JFrame frame;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInClass window = new SignInClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignInClass() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setSize(550,497);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Log in page");
		lblSignUp.setBounds(167, 38, 163, 46);
		lblSignUp.setBackground(new Color(0, 255, 255));
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblUsername = new JLabel("E-mail");
		lblUsername.setBounds(71, 130, 93, 27);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblUsername);
		
		emailField = new JTextField();
		emailField.setBounds(167, 127, 163, 30);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(71, 191, 85, 27);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(408, 24, 105, 30);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SignUpClass signUp = new SignUpClass();
								
			}
		});
		
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 193, 163, 27);
		frame.getContentPane().add(passwordField);
		
		JButton logInButton = new JButton("Log in");
		logInButton.setBackground(new Color(72, 209, 204));
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				String email=emailField.getText();
				String password = passwordField.getText();
							
				ReadXML read = new ReadXML();
				read.ReadXml(email, password);
				//boolean flag = false;
				if(read.flag==true) {
					JOptionPane.showMessageDialog(frame, "Successfully logged in.");
				}
				
				else JOptionPane.showMessageDialog(frame, "Password or Email is wrong..");
				
				
			}
		});
		logInButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logInButton.setBounds(186, 244, 124, 36);
		frame.getContentPane().add(logInButton);
		
		
	
	}
}
