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


public class Server extends Thread{
static Vector<ClientHandler> ar = new Vector<>();

static Vector<Thread> are = new Vector<>();

static Vector<String>userList = new Vector();
static int i=0;
  public static void main(String args[]) {
	  		
	  ReadXML authentic = new ReadXML();
	  		
	  		
	  		try {
	  			ServerSocket severLogin = new ServerSocket(9999);
	  			
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
	  				
	  				System.out.println("Sign up Sccessful.!!");
	  				
	  				writeXMLfile writeInfo = new writeXMLfile();
	  				
	  				try {
						writeInfo.writeXML(info[1], info[2], info[3], info[4],info[5]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  				
	  				
	  			}		
	  					
	  					
	  			
	  			else {
	  					
	  					
	  					String eMail = info[1];
	  					String pass = info[2];
	  					
	  					authentic.ReadXml(eMail, pass);
	  					
	  				if(authentic.flag==true) {	
	  					
	  					os.writeUTF("ok#!#Login Successful!!!" );
	  					//os.flush();
	  					
	  					
	  					
	  					System.out.println("server class::"+username);
	  					//System.out.println("Accepted client..."+username);
	  					
	  					
	  					
	  					ClientHandler clients = new ClientHandler(socketForClient,info[1],is,os);
	  					Thread newClient = new Thread(clients);
	  					
	  					
	  				
	  					System.out.println("thread id"+newClient.getId());
	  					
	  					ar.add(clients);
	  					
	  					newClient.start();
	  					i++;
	  					
	  					
	  					
	  			      }
	  				
	  				else {
	  					os.writeUTF("username or password is incorrect #!# " );
	  					
	  				}
	  				
	  			   }	
	  					
	  			}
	  			
	  			
	  		}catch(IOException e1) {
	  			System.out.println("connection problem occured...");
	  		}
	  }
}

