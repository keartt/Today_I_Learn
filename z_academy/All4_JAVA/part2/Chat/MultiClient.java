package Chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.*;
import java.net.Socket;
import javax.swing.*;


public class MultiClient extends JFrame implements ActionListener {

	private JTextField textField;		
	private JFrame jframe;				
	private JButton darkmodBtn;		
	private JButton inputBtn;		
	private JTextArea chat;				// 채팅 내용
	private JTextArea list;				// 참여자 리스트 
	private JPanel panel;			
	private Socket socket;				
	private ObjectInputStream ois;		
	private ObjectOutputStream oos;		
	private String ip;					
	private static String id;			

	// 생성자 함수
	public MultiClient(String argIp, String argId) {

		ip = argIp;
		id = argId;

		//GUI _ Jframe 디자인 부분
		jframe = new JFrame("Chat");
		jframe.setSize(500,480);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// 다크모드 버튼
		darkmodBtn = new JButton("다크모드");
		darkmodBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(darkmodBtn);
		
		// 채팅 내용 필드
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(45);

		// 입력 버튼
		inputBtn = new JButton("입력");
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(inputBtn);

		JPanel center = new JPanel();
		chat = new JTextArea("", 19, 70);
		list = new JTextArea("", 19, 20);
		list.setEditable(false);
		center.add(new JScrollPane(chat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.NORTH);
		center.add(new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		jframe.getContentPane().add(center,BorderLayout.NORTH);
		jframe.getContentPane().add(panel,BorderLayout.CENTER);

		chat.setEditable(false);
		list.setEditable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		jframe.pack();
		jframe.setLocation(
				(screenWidth - jframe.getWidth()) / 2,
				(screenHeight - jframe.getHeight()) / 2);
		jframe.setResizable(false);
		jframe.setVisible(true);

		
		// addActionListener
		textField.addActionListener(this);
		darkmodBtn.addActionListener(this);
		inputBtn.addActionListener(this);

		// 윈도우의 X버튼 클릭 시 종료
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					oos.writeObject(id);
					oos.writeObject(id+"#exit");
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				System.exit(0);
			}
			public void windowOpened(WindowEvent e) {
				textField.requestFocus();
			}
		});

	}

	// 액션이벤트 _ 텍스트필드&	다크모드&입력 버튼
	public void actionPerformed(ActionEvent e) {

		// e의 소스를 얻어 옴
		Object obj = e.getSource();		
		// textField의 문자를 얻어 옴
		String msg = textField.getText();

		// textField를 받았을 때의 실행
		if (obj == textField) {
			// 문자를 입력하지 않으면 경고, 그게 아니면 출력.
			if (msg == null || msg.length()==0) {
				JOptionPane.showMessageDialog(jframe, 
						"글을쓰세요", "경고",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					// 아이디 + # + 메시지
					oos.writeObject(id+"#"+msg);
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				textField.setText("");
			}
		} 
		// 다크모드
		else if (obj == darkmodBtn) {
			
			if (darkmodBtn.getText().equals("다크모드")){
				jframe.getContentPane().setBackground(Color.BLACK);
				darkmodBtn.setBackground(Color.DARK_GRAY);
				darkmodBtn.setForeground(Color.WHITE);
				inputBtn.setBackground(Color.DARK_GRAY);
				inputBtn.setForeground(Color.WHITE);
				textField.setBackground(Color.DARK_GRAY);
				textField.setForeground(Color.WHITE);
				chat.setBackground(Color.DARK_GRAY);
				chat.setForeground(Color.WHITE);
				list.setBackground(Color.DARK_GRAY);
				list.setForeground(Color.WHITE);
				panel.setBackground(Color.DARK_GRAY);
				panel.setForeground(Color.WHITE);

				darkmodBtn.setText("기본모드");
			}
			else{
				jframe.getContentPane().setBackground(Color.WHITE);
				darkmodBtn.setBackground(Color.WHITE);
				darkmodBtn.setForeground(Color.BLACK);
				inputBtn.setBackground(Color.WHITE);
				inputBtn.setForeground(Color.BLACK);
				textField.setBackground(Color.WHITE);
				textField.setForeground(Color.BLACK);
				chat.setBackground(Color.WHITE);
				chat.setForeground(Color.BLACK);
				list.setBackground(Color.WHITE);
				list.setForeground(Color.BLACK);
				panel.setBackground(Color.WHITE);
				panel.setForeground(Color.BLACK);

				darkmodBtn.setText("다크모드");
			}
		}
		// inputBtn을 받았을 때의 실행
		else if (obj == inputBtn) {
			// 문자를 입력하지 않으면 경고, 그게 아니면 출력.
			if (msg == null || msg.length()==0) {
				JOptionPane.showMessageDialog(jframe, 
						"글을쓰세요", "경고",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					oos.writeObject(id+"#"+msg);
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				textField.setText("");
			}
		}
	}

	// 종료
	public void exit(){
		System.exit(0);
	}

	// 클라이언트 소켓, 스트림, 스레드 생성
	public void init() throws IOException {

		// 소켓 생성
		socket = new Socket(ip, 5000);
		System.out.println("connected...");
		// 스트림 생성
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		// 클라이언트 스레드 생성
		MultiClientThread ct = new MultiClientThread(this);
		// 스레드 시작
		Thread t = new Thread(ct);
		t.start();
	}

	public ObjectInputStream getOis(){
		return ois;
	}

	public JTextField getTextField() {
		return textField;
	}

	public String getId(){
		return id;
	}

	public JTextArea getChat() {
		return chat;
	}

	public void setChat(JTextArea chat) {
		this.chat = chat;
	}

	public JTextArea getList() {
		return list;
	}

	public void setList(JTextArea list) {
		this.list = list;
	}

	public MultiClient(String id) throws IOException {
		JFrame.setDefaultLookAndFeelDecorated(true);

		// 클라이언트 생성
		MultiClient cc = new MultiClient("127.0.0.1",id);
		cc.init();
		cc.oos.writeObject(id);
		
	}
}