import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Properties.*;


import javax.swing.JOptionPane;

public class PServer {
   public static void main(String argv[]) {
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      Socket socket = null;
      String date = "";
      try {
        // open a socket connection
    	  String ip = JOptionPane.showInputDialog("Please enter Client IP");
       socket = new Socket(ip, 3000);
        // open I/O streams for objects
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        // read an object from the server
        System.out.println("wait????????????");
        int i;
        i=0;
        //get prop
        while(i<30)
        {
        date = (String) ois.readObject();
       
        System.out.println(date);
        i++;
        }
        System.out.println("end of client");
        
        /*Properties prop = System.getProperties();
	    Enumeration keys = prop.keys();
	    while (keys.hasMoreElements())
	    {
	    String key = (String)keys.nextElement();
	    String value = (String)prop.get(key);
	    //System.out.println(key + ": " + value);
	    }*/
        
        
       // System.out.print(" " + date);
        oos.close();
        ois.close();
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
   }
}
