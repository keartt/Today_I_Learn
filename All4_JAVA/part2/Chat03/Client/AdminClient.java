package Chat03.Client;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Chat03.Threads.AdminThread;

public class AdminClient extends JFrame implements ActionListener, KeyListener {

	JLabel chatLa, loginLa, listLa, userLa;
	JTextArea chatA, loginA, userA, listA;
	JButton kickBtn, darkmodBtn;

	// JList 사용을 위해
	// 서버 소켓에 연결할 소켓
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	// 생성자를 통해 시작
	public AdminClient() throws UnknownHostException, IOException {
		start();
		// 소켓 실행 .. 서버 소켓에 연결?
		socket = new Socket("127.0.0.1", 5000);
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		// 어드민 스레드 생성 > 스레드 시작
		AdminThread adminThread = new AdminThread(this);
		Thread t = new Thread(adminThread);
		t.start();
	}

	// GUI
	public void start() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		setTitle("관리자 페이지");
		setSize(1000, 700);
		// 창 크기 조정 불가하도록
		setResizable(false);
		getContentPane().setLayout(null);

		// 로그인 기록
		loginLa = new JLabel("로그인기록", JLabel.CENTER);
		loginLa.setBounds(680, 0, 270, 40);
		getContentPane().add(loginLa);
		
		loginA = new JTextArea();
		loginA.setBounds(680, 40, 270, 250);
		getContentPane().add(loginA);

		// 현재 채팅 내용 chatLa chatA
		chatLa = new JLabel("채팅 히스토리", JLabel.CENTER);
		chatLa.setBounds(20, 0, 630, 40);
		getContentPane().add(chatLa);
		chatLa.revalidate();
		chatLa.repaint();
		
		chatA = new JTextArea();
		chatA.setBounds(20, 40, 630, 250);
		getContentPane().add(chatA);

		// 접속 유저 목록 + 강퇴 버튼
		listLa = new JLabel("접속중", JLabel.LEFT);
		listLa.setBounds(20, 300, 150, 30);
		getContentPane().add(listLa);
		listLa.revalidate();
		listLa.repaint();

		listA = new JTextArea();
		listA.setBounds(20, 340, 200, 300);
		getContentPane().add(listA);
		listA.revalidate();
		listA.repaint();

		kickBtn = new JButton("강퇴");
		kickBtn.setBounds(150, 300, 70, 30);
		getContentPane().add(kickBtn);
		kickBtn.revalidate();
		kickBtn.repaint();
		kickBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = JOptionPane.showInputDialog("강퇴할 사람 이름");
				try {
					oos.writeObject("관리자#kick#" + msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		// 유저 정보
		userLa = new JLabel("회원정보", JLabel.CENTER);
		userLa.setBounds(240, 300, 700, 30);
		getContentPane().add(userLa);
		userLa.revalidate();
		userLa.repaint();

		userA = new JTextArea();
		userA.setBounds(240, 340, 710, 300);
		getContentPane().add(userA);
		userA.revalidate();
		userA.repaint();
		// 줄바꿈

		// 수정가능여부
		userA.setEditable(false);
		chatA.setEditable(false);
		loginA.setEditable(false);
		listA.setEditable(false); 

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public JTextArea getChatA() {
		return chatA;
	}

	public JTextArea getLoginA() {
		return loginA;
	}

	public JTextArea getUserA() {
		return userA;
	}
	public JTextArea getListA() {
		return listA;
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

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
