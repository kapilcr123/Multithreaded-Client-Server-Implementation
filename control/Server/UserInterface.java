import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class UserInterface extends JFrame implements ActionListener
{
	String type[]={"Select Type"};
	String ip[]={"Select ip address"};
	JComboBox c1,c2;
	JButton b1;
	HashMap v;
	PrintWriter out;
public UserInterface(String tit)
	{
	getContentPane().setLayout(null);
	setTitle(tit);
	JLabel title=new JLabel("Remote Shutdown Window");
Font f=new Font("Tahoma",Font.BOLD+Font.ITALIC,25);
title.setFont(f);
title.setForeground(Color.red);
title.setBounds(65,10,500,100);
getContentPane().add(title);
	c1 = new JComboBox(ip);
	c1.setBounds(50,100,150,30);
	getContentPane().add(c1);
	c2 = new JComboBox(type);
	c2.addItem("Restart");
	c2.addItem("Shutdown");
	c2.addItem("Lock");
	c2.addItem("Notepad");
	c2.setBounds(250,100,100,30);
	getContentPane().add(c2);
	b1 = new JButton("Submit");
	b1.setBounds(400,100,80,30);
	getContentPane().add(b1);
b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			String items=c2.getSelectedItem().toString();
			InetAddress inet=(InetAddress)c1.getSelectedItem();
			Socket socket=(Socket)v.get(inet);
			
			try{
		out=new PrintWriter(socket.getOutputStream(),true);
		if(items.equals("Shutdown"))
				{
		out.println("c:\\windows\\system32\\shutdown.exe -s");
				}
if(items.equals("Notepad"))
				{
		out.println("c:\\windows\\notepad.exe");
				}

				if(items.equals("Restart"))
				{
					out.println("c:\\windows\\system32\\shutdown.exe -r");
				}
				if(items.equals("Lock"))
				{
					out.println("c:\\WINDOWS\\System32\\rundll32.exe user32.dll,LockWorkStation");
				}
			}catch(Exception e){e.printStackTrace();}
			
		}
	}
	public void call(HashMap v)
	{
		this.v=v;
		c1.removeAllItems();
		System.out.println(v.size());
	Set set=v.entrySet();
	Iterator it=set.iterator();
	while(it.hasNext())
		{
		Map.Entry me=(Map.Entry)it.next();
		InetAddress add=(InetAddress)me.getKey();
		System.out.println(add);
		c1.addItem(add);
		//c1.updateUI();
		}
		
	}
	public static void main(String[] args)throws Exception 
	{
		UserInterface u=new UserInterface("Remote ShutDown");
		u.setVisible(true);
		u.setSize(500,200);
		u.setResizable(false);
		Server s=new Server(u);
		s.connect();
	}
}
