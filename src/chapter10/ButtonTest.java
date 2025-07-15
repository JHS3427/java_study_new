package chapter10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest {

	public static void main(String[] args)
	{
		Frame f = new Frame();
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		f.setLayout(new BorderLayout());
		Button btnClick = new Button("Button1!!");
		Button btnClick2 = new Button("Button2!!");
		Button btnClick3 = new Button("Button2!!");
		p.add(btnClick);	p2.add(btnClick2);	p3.add(btnClick3);
		f.add(p3,BorderLayout.SOUTH);
		f.add(p2,BorderLayout.CENTER);
		f.add(p,BorderLayout.NORTH);
		f.setSize(300,400);
		f.setTitle("버튼테스트");
		f.setVisible(true);
		//버턴의 이벤트 처리1. - 내부 클래스를 생성하여 액션 이벤트 처리
		
		//ButtonTest.ButtonActionListener action = new ButtonTest.ButtonActionListener();
		btnClick.addActionListener(new ButtonTest.ButtonActionListener());
		
		//버턴의 이벤트 처리2. - 익명(anonymous) 클래스를 생성하여 액션 이벤트 처리
		btnClick2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button2 Click!!!");
			}
		});
		/*ActionListener 얘는 인터페이스라 new 나 ()-생성자-를 원래 사용 못함
		그런데 위처럼 하면 되는 이유는 JVM이 알아서 무작위 클래스를 만들고 처리를 해주는거다.
		*/
		
		//버튼의 이벤트 처리3 - 람다식(자바 버젼 8 이상) 처리 방식을 이용한 이벤트 처리
		btnClick3.addActionListener((ActionEvent e)->{
			System.out.println("Button3 클");
		});
		btnClick3.addActionListener(e->System.out.println("Button3 클"));
		
		// 프레임의 종료 이벤트(X표 클릭)
		f.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent e){}
			public void windowClosed(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				System.out.println("시스템종료");
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}
			
		});
		
		
		
	}//main
	/**
	 * 이벤트 처리 클래스
	 */
	public static class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			System.out.print("click!!!");
		}
	}
}
