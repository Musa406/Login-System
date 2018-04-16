package vulnarrable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WebsiteClass {

	private JFrame frame;
	private JTextField userName;
	private JTextField eMail;
	private JTextField passWord;
	private JTextField birthDay;
	private JTextField genDar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebsiteClass window = new WebsiteClass(null, null, null, null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param birthday 
	 * @param password 
	 * @param email 
	 */
	public WebsiteClass(String user, String email, String password, String birthday,String gendar) {
		//initialize();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 575, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblWelcome = new JLabel("Welcome !!!");
		lblWelcome.setBackground(new Color(0, 0, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblWelcome.setBounds(145, 11, 232, 61);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUsername.setBounds(91, 110, 74, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmail.setBounds(96, 146, 66, 17);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(91, 181, 84, 26);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblBirthDay = new JLabel("Birth day ");
		lblBirthDay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBirthDay.setBounds(91, 218, 70, 26);
		frame.getContentPane().add(lblBirthDay);
		
		JLabel lblGendar = new JLabel("Gendar");
		lblGendar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblGendar.setBounds(91, 262, 73, 26);
		frame.getContentPane().add(lblGendar);
		
		userName = new JTextField();
		userName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		userName.setBounds(218, 109, 159, 26);
		userName.setText(user);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		eMail = new JTextField();
		eMail.setBounds(218, 146, 159, 26);
		eMail.setText(email);
		frame.getContentPane().add(eMail);
		eMail.setColumns(10);
		
		passWord = new JTextField();
		passWord.setBounds(218, 181, 159, 26);
		passWord.setText(password);
		frame.getContentPane().add(passWord);
		passWord.setColumns(10);
		
		birthDay = new JTextField();
		birthDay.setBounds(217, 223, 160, 26);
		birthDay.setText(birthday);
		frame.getContentPane().add(birthDay);
		birthDay.setColumns(10);
		
		genDar = new JTextField();
		genDar.setBounds(218, 267, 159, 26);
		genDar.setText(gendar);
		frame.getContentPane().add(genDar);
		genDar.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SignInClass signClass = new SignInClass();
				
			}
		});
		btnSignIn.setBounds(426, 185, 89, 23);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SignUpClass signUpClass = new SignUpClass();
			}
		});
		btnSignUp.setBounds(426, 237, 89, 23);
		frame.getContentPane().add(btnSignUp);
		
	}
}
