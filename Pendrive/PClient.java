import java.io.*;
import java.net.*;
import java.util.*;

public class PClient extends Thread {

   private ServerSocket PClient;
 

   public static void main(String argv[]) throws Exception {
     new PClient();
   }

   public PClient() throws Exception {
     PClient = new ServerSocket(3000);
     System.out.println("Server listening on port 3000.");
     this.start();
   } 

   public void run() {
     while(true) {
       try {
        System.out.println("Waiting for connections.");
        Socket client = PClient.accept();
        System.out.println("Accepted a connection from: "+
client.getInetAddress());
        Connect c = new Connect(client);
       } catch(Exception e) {}
     }
   }
}

class Connect extends Thread {
   private Socket client = null;
   private ObjectInputStream ois = null;
   private ObjectOutputStream oos = null;
    
   public Connect() {}

   public Connect(Socket clientSocket) {
     client = clientSocket;
     try {
      ois = new ObjectInputStream(client.getInputStream());
      oos = new ObjectOutputStream(client.getOutputStream());
     } catch(Exception e1) {
         try {
            client.close();
         }catch(Exception e) {
           System.out.println(e.getMessage());
         }
         return;
     }
     this.start();
   }

  
   public void run() {
      try {

	
	Properties prop = System.getProperties();
    Enumeration keys = prop.keys();
    while (keys.hasMoreElements()) {
    String key = (String)keys.nextElement();
    String value = (String)prop.get(key);
    //System.out.println(key + ": " + value);
    
    String kv=key.concat(value);
    
    
    
    
    
    
    oos.writeObject(FindDrive.msg());
    oos.flush();



}
   	
	 //cutted here
	
         // close streams and connections
         ois.close();
         oos.close();
         client.close(); 
      } catch(Exception e) {}       
   }
}
