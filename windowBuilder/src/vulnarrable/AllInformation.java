package vulnarrable;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class AllInformation {
	

	public int count = 0;
	//String []information=new String[100];
	public String [][]information2=new String[50][9];
	String columName[]={"Username", "email","password","Birthady","gendar"};
	
	
	public void getActionSwing(String username, String email,String password,String birthDay, String gendar) {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(1000, 800);
		
		mainFrame.setLayout(new FlowLayout());
		//JLabel firstName, surname, email, loginPassword, newEmail, reEnteredEmail, newPassword, day, month, year,
			//	gender, birthday,age;
		
		

		
		information2 [count][0]=username;
		information2 [count][1]=email;
		information2 [count][2]=password;
		
		information2 [count][3]=birthDay;
		information2 [count][5]=gendar;
		
		count+=1;
			
	
		//mainFrame.setVisible(true);
		
	
		   
		JButton clickButton = new JButton("Create a new account...");
		clickButton.setLayout(new FlowLayout());
		JButton exitButton=new JButton("exit");
		
		exitButton.setLayout(new FlowLayout());
		
				JTable jt=new JTable(information2, columName);
				jt.setBounds(50,40,100,200);
				//jt.setBounds(30, 30, 300, 300);
				for(int i=0; i<count; i++){
					jt.addRowSelectionInterval(i, count);
					JScrollPane sp=new JScrollPane(jt);
					mainFrame.add(sp);
				}
				int x=SignUpClass.counter;
				if(count==x)mainFrame.setVisible(true);
				
		
		clickButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			   mainFrame.setVisible(false);
			   SignInClass f1  = new SignInClass();
				
			}
		});
		
		
		
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainFrame.add(clickButton);
		mainFrame.add(exitButton);
		//mainFrame.add(information);
		

		

	}

	
}
