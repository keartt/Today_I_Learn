package day07.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionEventEx extends Frame implements ActionListener, WindowListener{

	Panel p;
	Button input, exit;
	TextArea ta;
	
	public ActionEventEx() {
		super("ActionEvent Test");
		
		p = new Panel();
		
		input =new Button("1");
		exit=new Button("xxx");
		ta = new TextArea();
		
		input.addActionListener(this);
		exit.addActionListener(this);
		
		p.add(input);
		p.add(exit);
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setBounds(300,300,300,200);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override // 이벤트 헨들러
	public void actionPerformed(ActionEvent e) {
		String name;
		name = e.getActionCommand();
		
		if (name.equals("1")) {
			ta.append("append1. \n");
		}else {
			ta.append("append2. \n");
			try {
				Thread.sleep(2000);
			} catch (Exception e2) {}
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new ActionEventEx();
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
//(this) = 자기자신 연결
//같은 클래스 내에 있기에 사용
//다른 클래스일 경우에 this X