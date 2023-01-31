package Test;

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
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginStart extends JFrame implements ActionListener, KeyListener {

	private JLabel laImage,laLogin;
	JTextField tf; // 아이디 입력 창
	JButton b1, b2; // 로그인 버튼 취소 버튼

	public LoginStart() {
		setTitle("Chat-Login");
		setSize(250, 300);
		getContentPane().setLayout(null); // 직접 배치

		// 이미지 크기 변환
		ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\shalp\\OneDrive\\바탕 화면\\all4land_junior\\Week01\\src\\Test\\2.jpg").getImage().getScaledInstance(300, 120,  java.awt.Image.SCALE_SMOOTH));
		laImage = new JLabel(icon);
		laImage.setBounds(-40, 10, 300, 120);
		getContentPane().add(laImage);
		
		// 로그인 부분 아이디  textField
		laLogin = new JLabel("아이디", JLabel.RIGHT);
		laLogin.setBounds(10, 150, 80, 30);
		tf = new JTextField();
		tf.setBounds(100, 150, 70, 30);
		getContentPane().add(laLogin);
		getContentPane().add(tf);

		b1 = new JButton("로그인");
		JPanel p = new JPanel(); // 패널을 배치하는 이유, 가운데 맞추기 어려워서 패널로 잡아준다
		p.add(b1);

		p.setOpaque(false); // setOpaque -투명모드
		p.setBounds(10, 200, 207, 35);
		getContentPane().add(p);

		b2 = new JButton("취   소");
		p.add(b2);

		b1.addActionListener(this); // 컴포넌트 이벤트를 처리할 컴포넌트 리스너를 추가.
		b2.addActionListener(this); // 컴포넌트 이벤트를 처리할 컴포넌트 리스너를 추가.
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String id = tf.getText();
			try {
				connection(id);
				dispose();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			System.exit(0);
		}

	}

	public void connection(String id) throws IOException {
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
