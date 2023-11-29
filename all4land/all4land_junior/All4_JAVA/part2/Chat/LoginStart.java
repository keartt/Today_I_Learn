package Chat;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginStart extends JFrame implements ActionListener, KeyListener {

	private JLabel laImage,laLogin, laLogin2;
	JTextField idF; // 아이디 입력 창
	JPasswordField pwF; // 비번 입력 창
	
	JButton loginBtn, b2; // 로그인 버튼 취소 버튼
	JButton joinBtn; // 회원가입 버튼

	public LoginStart() {
		setTitle("Chat-Login");
		setSize(350, 300);
		getContentPane().setLayout(null); // 직접 배치

		// 이미지 크기 변환
		ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\shalp\\OneDrive\\바탕 화면\\all4land_junior\\Week01\\part2\\2.jpg").getImage().getScaledInstance(300, 120,  java.awt.Image.SCALE_SMOOTH));
		laImage = new JLabel(icon);
		laImage.setBounds(0, -10, 300, 200);
		getContentPane().add(laImage);
		
		// 로그인 부분 아이디  textField
		laLogin = new JLabel("아이디", JLabel.RIGHT);
		laLogin.setBounds(-10, 170, 60, 30);
		
		laLogin2 = new JLabel("비밀번호", JLabel.RIGHT);
		laLogin2.setBounds(115, 170, 90, 30);
		
		idF = new JTextField();
		idF.setBounds(60, 170, 70, 30);
		
		
		pwF = new JPasswordField();
		pwF.setBounds(225, 170, 70, 30);
		
		getContentPane().add(laLogin);
		getContentPane().add(laLogin2);
		getContentPane().add(idF);
		getContentPane().add(pwF);

		JPanel p = new JPanel(); // 패널을 배치하는 이유, 가운데 맞추기 어려워서 패널로 잡아준다
		
		loginBtn = new JButton("로그인");
		p.add(loginBtn);

		p.setOpaque(false); // setOpaque -투명모드
		p.setBounds(35, 210, 250, 35);
		getContentPane().add(p);

		b2 = new JButton("취   소");
		p.add(b2);
		
		joinBtn = new JButton("회원가입");
		p.add(joinBtn);

		loginBtn.addActionListener(this); // 컴포넌트 이벤트를 처리할 컴포넌트 리스너를 추가.
		b2.addActionListener(this); // 컴포넌트 이벤트를 처리할 컴포넌트 리스너를 추가.
		joinBtn.addActionListener(this); // 컴포넌트 이벤트를 처리할 컴포넌트 리스너를 추가.
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			String id = idF.getText();
			String password = pwF.getText();
			try {
				// 로그인 성공 채팅 시작
				if (DBRun.loginCheck(id, password)==1) {
					startChat(DBRun.getNickname(id));
					dispose();
				// 비밀번호 오류 메시지
				}else if (DBRun.loginCheck(id, password)==2) {
					JOptionPane.showMessageDialog(null, "비번 틀림");
				// 아이디 부재 메시지	
				}else if (DBRun.loginCheck(id, password)==3){
					JOptionPane.showMessageDialog(null, "아이디 없음");
				}
				
				

			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		//  회원가입 버튼
		}else if (e.getSource() == joinBtn) {
			try {
				dispose();
				startJoin();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		else {
			System.exit(0);
		}

	}

	// 회원가입 페이지로 이동
	private void startJoin() {
		Join join = new Join();
		join.start();
		join.setVisible(true);
	}

	public void startChat(String id) throws IOException {
		// 로그인 버튼 -> 클라이언트 실행
		MultiClient mc = new MultiClient(id);
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

	public static void main(String[] args) throws IOException {
		new LoginStart().setVisible(true);
	}
}
