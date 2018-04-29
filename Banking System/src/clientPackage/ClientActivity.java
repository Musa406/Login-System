package clientPackage;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientActivity {

	private JFrame frame;

	Socket socketClient;
	private String clientName;
	final DataInputStream is;
	final DataOutputStream os;
	private String msg;
	private JTextField uNameF;
	private JTextField eMailF;
	private JLabel lblEmail;
	private JTextField birthF2;
	private JLabel lblBalance;
	private JTextField balancef;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientActivity window = new ClientActivity(null, null, null,null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ClientActivity(Socket socketClient, DataInputStream is,DataOutputStream os,String msg) {
		
		this.socketClient = socketClient;
		this.is = is;
		this.os = os;
		this.msg = msg;
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		uNameF = new JTextField();
		uNameF.setBounds(58, 73, 125, 19);
		frame.getContentPane().add(uNameF);
		uNameF.setColumns(10);
		
		JLabel lblMyAccount = new JLabel("My Account ");
		lblMyAccount.setBounds(160, 27, 114, 19);
		lblMyAccount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(lblMyAccount);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(217, 74, 70, 17);
		frame.getContentPane().add(lblName);
		
		eMailF = new JTextField();
		eMailF.setBounds(58, 104, 125, 19);
		frame.getContentPane().add(eMailF);
		eMailF.setColumns(10);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(217, 103, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		birthF2 = new JTextField();
		birthF2.setBounds(58, 135, 125, 19);
		frame.getContentPane().add(birthF2);
		birthF2.setColumns(10);
		
		lblBalance = new JLabel("birthday");
		lblBalance.setBounds(217, 137, 70, 15);
		frame.getContentPane().add(lblBalance);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDeposit.setBounds(58, 245, 117, 25);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(238, 245, 117, 25);
		frame.getContentPane().add(btnWithdraw);
		frame.setVisible(true);
		
		balancef = new JTextField();
		balancef.setBounds(58, 183, 125, 19);
		frame.getContentPane().add(balancef);
		balancef.setColumns(10);
		
		JLabel lblGendar = new JLabel("Balance");
		lblGendar.setBounds(217, 185, 70, 15);
		frame.getContentPane().add(lblGendar);
	
		
        String initialMsg[] = msg.split("#!#");
		
		uNameF.setText(initialMsg[1]);
		eMailF.setText(initialMsg[2]);
		birthF2.setText(initialMsg[3]);
		balancef.setText(initialMsg[4]);
		
		
		
		
		
		
		
		Thread receive = new Thread(new Runnable() {
			
			public void run()
			{
				while(true)
				{
					try {
						String msgFromServer = is.readUTF();
						String msg[] = msgFromServer.split("#!#");
						
						if(msg[0].equals("ok"))
						{
							uNameF.setText(msg[1]);
							eMailF.setText(msg[2]);    
							birthF2.setText(msg[3]);
							balancef.setText(msg[4]);
						}
						
						else JOptionPane.showMessageDialog(frame, "Something happend wrong...");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		
		receive.start();
		
		
		
	}
}
