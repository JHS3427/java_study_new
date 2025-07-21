package chapter17test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class TestServer {

	public static final int PORT = 9000;
	public static ArrayList<ClientHandler> list = new ArrayList<ClientHandler>();
	
	public static void main(String[] args) {
		try
		{
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("9000번 포트로 서버 시작");
			
			while(true)
			{
				Socket s = server.accept();
				System.out.println("데이터 수신");
				//System.out.println(s.getInputStream());
				ClientHandler ch = new ClientHandler(s);
				list.add(ch);
				ch.start();
			}
		}
		catch(Exception e)
		{}
	}
}

class ClientHandler extends Thread {
	Socket s;
	DataInputStream input;
	DataOutputStream output;
	
	public ClientHandler(Socket s) {
		super("테스트");
		try
		{
			this.s = s;
			this.input = new DataInputStream(s.getInputStream());
			this.output = new DataOutputStream(s.getOutputStream());
			String str = "[서버]환영합니다~^^";
			output.writeUTF(str);
		}
		catch(Exception e)
		{}
	}

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String receivedMsg = input.readUTF();
				System.out.println("receivedMsg : " +receivedMsg);
				TestServer.list.forEach(ch -> {
					try
					{
						ch.output.writeUTF(receivedMsg);
					}
					catch(Exception e2)
					{}
				});
			}
		}
		catch(Exception e)
		{}
	}	
}
