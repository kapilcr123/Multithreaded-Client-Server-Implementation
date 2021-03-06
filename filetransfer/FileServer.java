import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.*;
   import java.io.*;
   import java.net.*;
import javax.swing.*;

public class FileServer {

	private ServerSocket serv;
	private Socket client;
	private File myFile;

	public FileServer(int port, String fileName) throws IOException 
	{
		serv = new ServerSocket(port);
		myFile = new File (fileName);
		
		while(true)
		{
			//wait for Connection
			System.out.println("Waiting for connection on port "+port);
			client=serv.accept();
			sendFile();
		}
	}

	public void sendFile() throws IOException 
	{
		
		if (!myFile.exists()) {
			System.out.println("File doesn not exist!");
			System.exit(-1);
		} 
		
		//file do exist
		
		System.out.println("AbsolutePath:" + myFile.getAbsolutePath());
		System.out.println("length: " + myFile.length());
		
		if (myFile.exists()) {
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			
			oos.writeObject(myFile);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		int port = 9999;
		
		//String fileName = "C:\\workspace\\Sve\\src\\feb15\\ab.jpg";

                    // String fileName = "D:\\hai.txt";
String fileName=JOptionPane.showInputDialog("enter the file path");		

		try {
			FileServer fs = new FileServer(port, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}/// 
 
