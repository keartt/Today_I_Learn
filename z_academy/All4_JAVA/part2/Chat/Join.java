package Chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Join extends JFrame implements ActionListener, KeyListener {
	
	JLabel idLabel, pwLabel, niLabel; // 아이디, 비번, 닉네임 라벨
	
	JTextField idF,pwF ,niF; // 아이디, 비번, 닉네임 입력 필드
	
	JButton in, out; // 가입, 취소 버튼
	
//	public static void main(String[] args) {
//		Join join = new Join();
//		join.start();
//		join.setVisible(true);
//	}
//	
////	public Join() {
////		// 회원가입 창 시작
////		start();
////		// 다시 로그인 창으로 반환
////		new LoginStart().setVisible(true);
////	}
	
	public void start() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		setTitle("회원가입");
		setSize(350, 300);
		getContentPane().setLayout(null); // 직접 배치
		
		idLabel = new JLabel("아이디", JLabel.RIGHT);
		idLabel.setBounds(50, 40, 60, 30);
		getContentPane().add(idLabel);
		
		pwLabel = new JLabel("비밀번호", JLabel.RIGHT);
		pwLabel.setBounds(50, 90, 60, 30);
		getContentPane().add(pwLabel);
		
		niLabel = new JLabel("닉네임", JLabel.RIGHT);
		niLabel.setBounds(50, 140, 60, 30);
		getContentPane().add(niLabel);
		
		
		idF = new JTextField();
		idF.setBounds(150, 40, 100, 30);
		getContentPane().add(idF);
		
		pwF = new JTextField(); 
		pwF.setBounds(150, 90, 100, 30);
		getContentPane().add(pwF);
		
		niF = new JTextField();
		niF.setBounds(150, 140, 100, 30);
		getContentPane().add(niF);
		
		JPanel p = new JPanel();
		
		in = new JButton("회 원 가입");
		p.add(in);
		
		out = new JButton("종   료");
		p.add(out);
		
		p.setBounds(35, 190, 250, 35);
		getContentPane().add(p);
		
		in.addActionListener(this); 
		out.addActionListener(this); 
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	// 버튼 입력 시 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == in) {
			String id = idF.getText();
			String password = pwF.getText();
			String nickname = niF.getText();
			try {
				// 아이디 중복검사 먼저 실시
				if (!DBRun.duplicate_check(id)) {
					JOptionPane.showMessageDialog(null, "아이디중복");
					dispose();
					start();
					setVisible(true);
				}
				else {
					dispose();
					DBRun.join(id, password,nickname);
					new LoginStart().setVisible(true);
				}
				// 입력버튼 입력 시 DBRun 클래스로 가서 - static 메소드 조인
				// 디비에 아이디, 비번, 닉네임 insert
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				System.out.println(" 버튼에서 오류");
			}
		}else { // 다른 버튼 입력 시 종료 
			System.exit(0);
		}
	}
	
	
	
}
