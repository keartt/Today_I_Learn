package day07.awt;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class ButtonEx {
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		
		// 하나씩 버튼을 올리기 힘들기에
		//패널에 올린 뒤 패널을 올림
		Panel p = new Panel();
		
		Button b1 = new Button();
		Button b2 = new Button("btn 1");
		Button b3 = new Button("btn 2");
		Button b4 = new Button("btn 3");
		
		// 이름을 부여하는 다른 방법 
		b1.setLabel("btn4");
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		// 패널을 올림
		f.add(p);
		
		// 생성 위치
		f.setLocation(900,300);
		// 크기 + 실행 
		f.setSize(300,300);
		f.setVisible(true);
	}
}
