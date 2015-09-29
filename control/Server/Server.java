import java.net.*;
import java.util.*;
public class Server
{
ServerSocket server;
UserInterface in;
HashMap v=new HashMap();
Socket s;
Server(UserInterface in)
	{
	this.in=in;
	try{
		v.clear();
	server = new ServerSocket(4444);
	}catch(Exception e)
		{
		e.printStackTrace();
		}}
	public void connect()throws Exception
	{
	while(true)
		{
		s=server.accept();
		v.put(s.getInetAddress(),s);
		MultiThreaded m=new MultiThreaded(server,in,v);
		}
		
	}
}
