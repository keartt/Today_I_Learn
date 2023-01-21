package Chat03.Client;

import java.awt.Color;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Chat03.Threads.MultiClientThread;
import Chat03.db.DBRun;

public class MultiClient extends JFrame implements ActionListener, KeyListener{
	
	private JLabel nameL;
	private JTextArea chat, list;
	private JTextField textField;		
	private JButton darkmodBtn, inputBtn, listBtn, wBtn;		
	private String ip;					
	private static String name;
	
	private Socket socket;				
	private ObjectInputStream ois;		
	private ObjectOutputStream oos;	
	
	public MultiClient(String argIP, String ariId) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		
		ip = argIP;
		name = ariId;
		
		// 전체 사이즈 & 틀
		setTitle("채팅방");
		setSize(360, 490);
		setResizable(false);
		getContentPane().setLayout(null);
		

		// 유저 본인 이름 label
		nameL = new JLabel("이름 :" + getName(), JLabel.LEFT);
		nameL.setBounds(10, 10, 80, 30);
		getContentPane().add(nameL);
		nameL.repaint();
		nameL.revalidate();
		
		// 채팅 내용 area
		chat = new JTextArea();
		JScrollPane chatScrollPane = new JScrollPane(chat);
		chatScrollPane.setBounds(10,45,330, 350);
		getContentPane().add(chatScrollPane);
		chat.setEditable(false);
		
		// 리스트 목록 
		list = new JTextArea();
		list.setBounds(10,45,330, 350);
		getContentPane().add(list);
		list.revalidate();
		list.repaint();
		list.setVisible(false);
		
		
		// 채팅 입력 창 textField
		textField = new JTextField();
		textField.setBounds(10,410, 190, 33);
		getContentPane().add(textField);
		textField.revalidate();
		textField.repaint();

		// 귓속말 버튼 wBtn
		wBtn = new JButton("귓말");
		wBtn.setBounds(205,410, 65, 33);
		getContentPane().add(wBtn);
		wBtn.revalidate();
		wBtn.repaint();
		
		// 입력 버튼 inputBtn
		inputBtn = new JButton("입력");
		inputBtn.setBounds(275,410, 65, 33);
		getContentPane().add(inputBtn);
		inputBtn.revalidate();
		inputBtn.repaint();
		
		// 다크모드 버튼 darkmodBtn
		darkmodBtn = new JButton("■");
		darkmodBtn.setBounds(195, 5, 45, 33);
		getContentPane().add(darkmodBtn);
		darkmodBtn.revalidate();
		darkmodBtn.repaint();
		
		// 사용자 리스트 버튼 
		listBtn = new JButton("접속유저");
		listBtn.setBounds(245, 5, 95, 33);
		getContentPane().add(listBtn);
		listBtn.revalidate();
		listBtn.repaint();
		
		
		// addActionListener
		textField.addActionListener(this);
		darkmodBtn.addActionListener(this);
		inputBtn.addActionListener(this);
		listBtn.addActionListener(this);
		wBtn.addActionListener(this);

		// 윈도우의 X버튼 클릭 시 종료
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					oos.writeObject(name);
					oos.writeObject(name+"#exit");
					
					exit();
				} catch (IOException ee) {
					ee.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			public void windowOpened(WindowEvent e) {
				textField.requestFocus();
			}
		});
	}

	
	// 액션이벤트 _ 텍스트필드& 다크모드& 입력 버튼
	public void actionPerformed(ActionEvent e) {

		// e의 소스를 얻어 옴
		Object obj = e.getSource();		
		// textField의 문자를 얻어 옴
		String contents = textField.getText();

		// textField를 받았을 때의 실행
		if (obj == textField) {
			// 문자를 입력하지 않으면 경고, 그게 아니면 출력.
			if (contents == null || contents.length()==0) {
				JOptionPane.showMessageDialog(null, 
						"글을쓰세요", "경고",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					// DB 에 채팅 내용 저장
					DBRun.ChatEvery(name, contents);
					// 아이디를 이름으로 바꾸고 + # + 메시지
					oos.writeObject( name+"#"+contents);
				} catch (IOException ee) {
					ee.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				textField.setText("");
			}
		// 귓말
		} else if (obj == wBtn) {
			String receiver =  JOptionPane.showInputDialog("귓말 보낼 사람");
			String contentW =  JOptionPane.showInputDialog("내용");
			
			try {
				// 0:보낸사람, 1:귓말, 2:받는사람, 3:내용
				DBRun.ChatWhisper(name, receiver, contentW);
				oos.writeObject(name+"#귓말#"+receiver+"#"+contentW);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		// inputBtn을 받았을 때의 실행
		else if (obj == inputBtn) {
			// 문자를 입력하지 않으면 경고, 그게 아니면 출력.
			if (contents == null || contents.length()==0) {
				JOptionPane.showMessageDialog(null, "내용을 입력하세요");
			} else {
				try {
					DBRun.ChatEvery(name, contents);
					oos.writeObject(name+"#"+contents);
				} catch (IOException ee) {
					ee.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				textField.setText("");}
			}
		// 다크모드
		else if (obj == darkmodBtn) {
			
			if (darkmodBtn.getText().equals("■")){
				getContentPane().setBackground(Color.BLACK);
				darkmodBtn.setBackground(Color.DARK_GRAY);
				darkmodBtn.setForeground(Color.WHITE);
				listBtn.setBackground(Color.DARK_GRAY);
				listBtn.setForeground(Color.WHITE);
				inputBtn.setBackground(Color.DARK_GRAY);
				inputBtn.setForeground(Color.WHITE);
				wBtn.setBackground(Color.DARK_GRAY);
				wBtn.setForeground(Color.WHITE);
				textField.setBackground(Color.DARK_GRAY);
				textField.setForeground(Color.WHITE);
				chat.setBackground(Color.DARK_GRAY);
				chat.setForeground(Color.WHITE);
				list.setBackground(Color.DARK_GRAY);
				list.setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
				setForeground(Color.WHITE);

				darkmodBtn.setText("□");
			}
			else{
				getContentPane().setBackground(Color.WHITE);
				darkmodBtn.setBackground(Color.WHITE);
				darkmodBtn.setForeground(Color.BLACK);
				listBtn.setBackground(Color.WHITE);
				listBtn.setForeground(Color.BLACK);
				inputBtn.setBackground(Color.WHITE);
				inputBtn.setForeground(Color.BLACK);
				wBtn.setBackground(Color.WHITE);
				wBtn.setForeground(Color.BLACK);
				textField.setBackground(Color.WHITE);
				textField.setForeground(Color.BLACK);
				chat.setBackground(Color.WHITE);
				chat.setForeground(Color.BLACK);
				list.setBackground(Color.WHITE);
				list.setForeground(Color.BLACK);
				setBackground(Color.WHITE);
				setForeground(Color.BLACK);

				darkmodBtn.setText("■");
			}
		// 사용자 목록 띄우기 버튼 	
		}else if (obj == listBtn) {
				if (listBtn.getText().equals("접속유저")){
					chat.setVisible(false);
					list.setVisible(true);
					listBtn.setText("채팅내용");
				}
				else{
					chat.setVisible(true);
					list.setVisible(false);
					listBtn.setText("접속유저");
				}
		// 귓말 버튼
		}
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
	
	// 종료
	public void exit() throws ClassNotFoundException{
//		DBRun.Login_out(LoginStart.getId());
		System.exit(0);
	}

	public ObjectInputStream getOis(){
		return ois;
	}
	public JTextField getTextField() {
		return textField;
	}
	public String getName(){
		return name;
	}
	public JTextArea getChat() {
		return chat;
	}
	public JTextArea getList() {
		return list;
	}

	// 클라이언트 소켓, 스트림, 스레드 생성
		public void init() throws IOException {
			// 소켓 생성
			socket = new Socket(ip, 5000);
			System.out.println("connected...");
			// 스트림 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			// 입장 메시지 전송용
			oos.writeObject(getName()+"#"+"in");
			// 클라이언트 스레드 생성
			MultiClientThread ct = new MultiClientThread(this);
			// 스레드 시작
			Thread t = new Thread(ct);
			t.start();
		}
		
		public MultiClient(String name) throws IOException {

			// 클라이언트 생성
			MultiClient cc = new MultiClient("127.0.0.1",name);
			cc.setVisible(true);
			cc.init();
			cc.oos.writeObject(name);
			
		}	
}
