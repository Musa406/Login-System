package serverPackage;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JOptionPane;


public class Server extends Thread{

public static void main(String args[]) {
	  		
	  ReadXML authentic = new ReadXML();
	  		
	  		
	  		try {
	  			ServerSocket severLogin = new ServerSocket(9997);
	  			
	  			//ServerSocket severMainSocketList = new ServerSocket(9999);//for user list sending
	  		
	  			while(true) {
	  				    	  				
	  					
	  					Socket socketForClient = severLogin.accept();
	  					
	  					
	  					DataInputStream is = new DataInputStream(socketForClient.getInputStream());
	  					DataOutputStream os = new DataOutputStream(socketForClient.getOutputStream());
	  					//input,output
	  					
	  					
	  					String username = is.readUTF();
	  					
	  					String [] info = username.split("#!#");
	  					
	  					
	  					
			  			if(info[0].equals("signUp"))
			  			{
			  				//JOptionPane.showMessageDialog(frame,"Successfully SignUp");
			  				System.out.println("Sign up Sccessful.!!");
			  				
			  				writeXMLfile writeInfo = new writeXMLfile();
			  				
			  				try {
								writeInfo.writeXML(info[1], info[2], info[3], info[4],info[5]);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  				
			  				
			  			}		
	  					
	  					
		  			
			  			else if(info[0].equals("login"))
			  			{
			  					System.out.println("check1 ");
			  					
			  					String eMail = info[1];
			  					String pass = info[2];
			  					
			  					String allInfo2 = authentic.ReadXml(eMail, pass);
			  					
			  				if(authentic.flag==true)
			  				{	
			  					
			  						System.out.println("allInfo::"+allInfo2);
			  						System.out.println("check2 ");
			  						
				  					os.writeUTF("ok#!#"+allInfo2);
				  					
		  					  					
			  					
			  			    }
			  				
				  			else
				  			{
				  					os.writeUTF("loginFailed#!#username or password is incorrect");
				  					
				  			}
			  				
			  				
			  			   }
			  			
				  	
			  			else if(info[0].equals("deposit")) 
				  		{
				  				
				  		}
				  			
				  		else if(info[0].equals("withdraw")) 
				  		{
				  				
				  		}
			  			
				  		else System.out.println("mra khaise!!!!!");
			  			
	  					
	  		}
	  			
	  			
	  		}catch(IOException e1) {
	  			System.out.println("connection problem occured...");
	  		}
	  }
}



