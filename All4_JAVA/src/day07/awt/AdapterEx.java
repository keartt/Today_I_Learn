package day07.awt;

import java.awt.*;
import java.awt.event.*;

public class AdapterEx extends Frame implements ActionListener {

	Panel p1, p2, p3;
	KeyEvent e;
	TextField tf;
	TextArea ta;

	Button b1, b2;

	public AdapterEx() {

		super("Adapter Test");

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		tf = new TextField(35);
		ta = new TextArea(10, 35);

		b1 = new Button("Clear");
		b2 = new Button("Exit");

		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add("North", p1);
		add("Center", p2);
		add("South", p3);

		setBounds(300, 200, 300, 300);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);

		
		// 익명 이너 
		tf.addKeyListener(new KeyAdapter(){ 
			public void keyTyped(KeyEvent e){
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					ta.append(tf.getText()+"\n");
					tf.setText("");
				}
			}	
		});
		

		
		
//		addWindowListener(new WindowEventHandler());
		// 익명 이너 클래스
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
//	tf.addKeyListener(new KeyEventHandler());
	// 멤버 이너 클래스
//		class KeyEventHandler extends KeyAdapter{ 
//			public void keyTyped(KeyEvent e){
//				if(e.getKeyChar() == KeyEvent.VK_ENTER){
//					ta.append(tf.getText()+"\n");
//					tf.setText("");
//				}
//			}	
//		}
	
	

	@Override // 액션 이벤트 헨들러
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Clear")) { // 클리어 버튼
			ta.setText("");
			tf.setText("");
			tf.requestFocus(); // 커서 깜빡이기
		} else if (str.equals("Exit")) { // exit 버튼
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new AdapterEx();
		
	}

}

// -> member	99 to 67 to 45
//class KeyEventHandler extends KeyAdapter{
//	TextField tf;
//	TextArea ta;
//
//	public KeyEventHandler(TextField tf, TextArea ta){
//		this.tf=tf;
//		this.ta=ta;
//	}
//
//	public void keyTyped(KeyEvent e){
//		if(e.getKeyChar() == KeyEvent.VK_ENTER){	// 엔터 누르면
//			ta.append(tf.getText()+"\n");			// 텍스트창에 - 입력창 내용을 넣고 \n
//			tf.setText("");							// 입력창 비우기
//		}
//	}	
//}

// -> annony
//class WindowEventHandler extends WindowAdapter{ 
//	public void windowClosing(WindowEvent e){
//		System.exit(0);
//	}
//}
