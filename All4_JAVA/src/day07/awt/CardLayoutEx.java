package day07.awt;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardLayoutEx extends Frame {
	CardLayout card;
	Panel p1, p2, p3;
	
	public CardLayoutEx() {
		super("CARD LAYOUT");
		
		card = new CardLayout();
		setLayout(card);
		
		p1 = new Panel();
		p1.add(new Button("1번"));
		p1.add(new Button("2번"));
		
		p2 = new Panel();
		p2.add(new Button("3번"));
		p2.add(new Button("4번"));
		
		p3 = new Panel();
		p3.add(new Button("5번"));
		p3.add(new Button("6번"));
		
		
		add("1", p1);
		add("2", p2);
		add("3", p3);
		
		// 윈도우 리스너 사용
//		addWindowListener(this);
		
//		// 윈 어뎁터 무명클래스 
//		new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		};
		
		// 기존 방법과 무명클래스 사용 방법을 통합해?
		this.addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);   
                    }
                }
            );
		

	}
	
	public void rotate() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		card.next(this);
	}
	
	
	public static void main(String[] args) {
		CardLayoutEx c = new CardLayoutEx();
		
		c.setBounds(900,100,400,200);
		c.setVisible(true);
		c.rotate();
		
	}

	
//	////
//	
//	@Override
//	public void windowOpened(WindowEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.exit(0);
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		// TODO Auto-generated method stub}

	
}

