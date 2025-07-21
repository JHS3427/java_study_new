package chapter17test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) {
		String id = "홍길동";
		final String HOST = "localhost";
		final int PORT = 9000;
		Frame f = new Frame("채팅 클라이언트");
		Panel p = new Panel();
		f.setLayout(new BorderLayout());
		TextArea ta = new TextArea();
		TextField tf = new TextField(40);
		Button send = new Button("전송");
		Button button1 = new Button("종료");
		ta.setEditable(false);
		tf.setText("["+id+"] ");
		p.add(tf);		p.add(send);	
		
		try
		{
			Socket s = new Socket(HOST, PORT);
			DataInputStream input = new DataInputStream(s.getInputStream());
			DataOutputStream output = new DataOutputStream(s.getOutputStream());
			System.out.println("서버 연결 성공");
			//System.out.println(s.getOutputStream());
			new ServiceThread(input,ta).start();
			
            f.add(p, BorderLayout.NORTH);
            f.add(ta, BorderLayout.CENTER);
			f.add(button1, BorderLayout.SOUTH);
			f.setSize(400, 500);
			f.setVisible(true);	
			

			send.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						output.writeUTF(tf.getText());	
						tf.setText("["+ id + "] ");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
						
            //종료 이벤트
            button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("-- 클라이언트 종료 --");
						output.writeUTF("exit");
						System.exit(0);						
					} catch (Exception e2) {}
				}
			});				
		}
		catch (Exception e)
		{}
	}

}

class ServiceThread extends Thread {
	DataInputStream input;
	TextArea ta;
	
	public ServiceThread(DataInputStream input, TextArea ta) {
		this.input = input;
		this.ta = ta;
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				ta.append(input.readUTF());
			}
		}
		catch(Exception e)
		{}
	}
}
