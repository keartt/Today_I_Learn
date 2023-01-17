package Chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private MultiServer ms;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	// 생성자
	public MultiServerThread(MultiServer ms) {
		this.ms = ms;
	}

	// 스레드 run - synchronized .. 단일
	public synchronized void run() {

		boolean isStop = false;

		try {
			socket = ms.getSocket();
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			String message = null;

			// 무한 루프
			while (!isStop) {
				// 받은 인풋 값 to String
				message = (String) ois.readObject();
				String[] str = message.split("#");
				
				// #이 없으면 id를 UserList에 포함
				if (!message.contains("#")) {
					if (ms.getUserList().contains(message)) {
						ms.getUserList().remove(message);
					} else {
						ms.getUserList().add(message);
					}

					broadCasting(ms.getUserList());
				} else {
					
					// 입력이 exit 면
					if (str[1].equals("exit")) {
						ms.getUserList().remove(str[0]);
						broadCasting(ms.getUserList());
						broadCasting(message);
						// 탈출
						isStop = true;
					} 
					else if (str[1].contains("kick")) {
						ms.getUserList().remove(str[2]);
						broadCasting(ms.getUserList());
						broadCasting(message);
						// 탈출
						isStop = true;
					}

					// 메시지를 보낸다
					else {
						broadCasting(message);
					}
				}
			}
			// 스레드 종료
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + " 정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		} catch (Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + " 비정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		}
	}

	public void broadCasting(String message) throws IOException {
		for (MultiServerThread ct : ms.getList()) {
			ct.send(message);
		}
	}

	public void broadCasting(ArrayList<String> arraylist) throws IOException {
		for (MultiServerThread ct : ms.getList()) {
			ct.send(arraylist);
		}
	}

	public void send(String message) throws IOException {
		oos.writeObject(message);
	}

	public void send(ArrayList<String> arraylist) throws IOException {
		String str = "";
		for (String a : arraylist) {
			str += a + "\n";
		}
		oos.writeObject(str);
	}

}
